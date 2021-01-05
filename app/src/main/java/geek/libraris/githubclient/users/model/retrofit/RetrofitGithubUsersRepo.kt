package geek.libraris.githubclient.users.model.retrofit

import geek.libraris.githubclient.common.network.INetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.IUserCache
import geek.libraris.githubclient.common.room.RoomGithubUser
import geek.libraris.githubclient.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(val api: IUsersSource, val networkStatus: INetworkStatus, val db: Database, val cache : IUserCache) : IGithubUsersRepo {
    override fun getUsers(): Single<List<GithubUser>> = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getUsers()
                .flatMap { users ->
                    Single.fromCallable {
                        cache.insertToCache(users, db)
                        users
                    }
                }
        } else {
                cache.findInCache(db)
        }
    }.subscribeOn(Schedulers.io())
}


