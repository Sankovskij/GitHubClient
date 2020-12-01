package geek.libraris.githubclient.repos.model.retrofit

import geek.libraris.githubclient.common.network.INetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.RoomGithubRepository
import geek.libraris.githubclient.repos.model.entity.GithubRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUserRepos(val api: IReposSourse, val networkStatus: INetworkStatus, val db: Database): IGithubUserRepos {
  //  override fun getRepos(login: String?)=  api.loadRepos(login).subscribeOn(Schedulers.io())


//Практическое задание 1 - вытащить кэширование в отдельный класс RoomRepositoriesCache и внедрить его сюда через интерфейс IRepositoriesCache


    override fun getRepos(login: String?) {
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                login?.let { login ->
                    api.loadRepos(login)
                        .flatMap { repositories ->
                            Single.fromCallable {
                                val roomUser = login?.let { db.userDao.findByLogin(it) }
                                    ?: throw RuntimeException("No such user in cache")
                                val roomRepos = repositories.map {
                                    RoomGithubRepository(
                                        it.id ?: "",
                                        it.name ?: "",
                                        it.description ?: "",
                                        it.size ?: 0,
                                        it.language ?: "",
                                        roomUser.id
                                    )
                                }
                                db.repositoryDao.insert(roomRepos)
                                repositories
                            }
                        }
                } ?: Single.error<List<GithubRepository>>(RuntimeException("User has no repos url"))
                    .subscribeOn(Schedulers.io())
            } else {
                Single.fromCallable {
                    val roomUser = login?.let { db.userDao.findByLogin(it) }
                        ?: throw RuntimeException("No such user in cache")
                    db.repositoryDao.findForUser(roomUser.id).map {
                        GithubRepository(
                            it.id ?: "",
                            it.name ?: "",
                            it.description ?: "",
                            it.size ?: 0,
                            it.language ?: ""
                        )
                    }
                }

            }
        }.subscribeOn(Schedulers.io())
    }
}

