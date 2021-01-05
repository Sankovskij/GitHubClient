package geek.libraris.githubclient.repos.model.retrofit

import geek.libraris.githubclient.common.network.INetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.IRepositoriesCache
import geek.libraris.githubclient.common.room.IUserCache
import geek.libraris.githubclient.common.room.RoomGithubRepository
import geek.libraris.githubclient.repos.model.entity.GithubRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUserRepos(val api: IReposSourse, val networkStatus: INetworkStatus, val db: Database, val cache: IRepositoriesCache): IGithubUserRepos {
  //  override fun getRepos(login: String?)=  api.loadRepos(login).subscribeOn(Schedulers.io())


//Практическое задание 1 - вытащить кэширование в отдельный класс RoomRepositoriesCache и внедрить его сюда через интерфейс IRepositoriesCache


    override fun getRepos(login: String?) = networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                login?.let { login ->
                    api.loadRepos(login)
                        .flatMap { repositories ->
                            Single.fromCallable {
                                cache.insertToCache(login, repositories, db)
                                repositories
                            }
                        }
                } ?: Single.error<List<GithubRepository>>(RuntimeException("User has no repos url"))
                    .subscribeOn(Schedulers.io())
            } else {
                cache.findInCache(login, db)

            }
        }.subscribeOn(Schedulers.io())
    }


