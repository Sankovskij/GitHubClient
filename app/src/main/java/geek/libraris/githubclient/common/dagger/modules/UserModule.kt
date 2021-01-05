package geek.libraris.githubclient.common.dagger.modules

import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.common.dagger.scopes.UserScope
import geek.libraris.githubclient.common.network.INetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.IUserCache
import geek.libraris.githubclient.common.room.RoomUserCache
import geek.libraris.githubclient.users.model.retrofit.IGithubUsersRepo
import geek.libraris.githubclient.users.model.retrofit.IUsersSource
import geek.libraris.githubclient.users.model.retrofit.RetrofitGithubUsersRepo

@Module
class UserModule {

    @Provides
    fun usersCache(): IUserCache = RoomUserCache()

    @UserScope
    @Provides
    fun usersRepo(usersApi: IUsersSource, networkStatus: INetworkStatus, db: Database, cache: IUserCache): IGithubUsersRepo = RetrofitGithubUsersRepo(usersApi, networkStatus, db,cache)

}