package geek.libraris.githubclient.common.dagger.modules

import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.common.dagger.scopes.RepositoryScope
import geek.libraris.githubclient.common.network.INetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.IRepositoriesCache
import geek.libraris.githubclient.common.room.RoomRepositoriesCache
import geek.libraris.githubclient.repos.model.retrofit.IGithubUserRepos
import geek.libraris.githubclient.repos.model.retrofit.IReposSourse
import geek.libraris.githubclient.repos.model.retrofit.RetrofitGithubUserRepos

@Module
open class RepositoryModule {
    @Provides
    fun reposCache(): IRepositoriesCache = RoomRepositoriesCache()


    @RepositoryScope
    @Provides
    fun reposRepo(
        reposApi: IReposSourse,
        networkStatus: INetworkStatus,
        db: Database,
        cache: IRepositoriesCache
    ): IGithubUserRepos = RetrofitGithubUserRepos(reposApi, networkStatus, db, cache)

}
