package geek.libraris.githubclient.common.room

import geek.libraris.githubclient.repos.model.entity.GithubRepository
import io.reactivex.rxjava3.core.Single

class RoomRepositoriesCache : IRepositoriesCache {
    override fun findInCache(login: String?, db: Database): Single<List<GithubRepository>> = Single.fromCallable {
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

    override fun insertToCache(login: String?,repositories: List<GithubRepository>, db: Database) {
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
    }
}




}