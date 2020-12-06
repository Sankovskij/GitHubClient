package geek.libraris.githubclient.common.room

import geek.libraris.githubclient.repos.model.entity.GithubRepository
import geek.libraris.githubclient.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IUserCache {
    fun insertToCache(users : List<GithubUser>, db : Database)
    fun findInCache(db: Database): Single<List<GithubUser>>
}