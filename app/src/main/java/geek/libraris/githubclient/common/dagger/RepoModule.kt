package geek.libraris.githubclient.common.dagger

import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.common.network.INetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.IRepositoriesCache
import geek.libraris.githubclient.common.room.IUserCache
import geek.libraris.githubclient.repos.model.retrofit.IGithubUserRepos
import geek.libraris.githubclient.repos.model.retrofit.IReposSourse
import geek.libraris.githubclient.repos.model.retrofit.RetrofitGithubUserRepos
import geek.libraris.githubclient.users.model.retrofit.IGithubUsersRepo
import geek.libraris.githubclient.users.model.retrofit.IUsersSource
import geek.libraris.githubclient.users.model.retrofit.RetrofitGithubUsersRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(usersApi: IUsersSource, networkStatus: INetworkStatus, db: Database, cache: IUserCache): IGithubUsersRepo = RetrofitGithubUsersRepo(usersApi, networkStatus, db,cache)

    @Singleton
    @Provides
    fun reposRepo(reposApi: IReposSourse, networkStatus: INetworkStatus, db: Database, cache: IRepositoriesCache): IGithubUserRepos = RetrofitGithubUserRepos(reposApi, networkStatus,db, cache)

}

