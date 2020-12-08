package geek.libraris.githubclient.common.dagger

import dagger.Subcomponent
import geek.libraris.githubclient.common.dagger.modules.RepositoryModule
import geek.libraris.githubclient.common.dagger.scopes.RepositoryScope
import geek.libraris.githubclient.repos.presenter.ReposPresenter

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class
    ]
)
interface RepositorySubcomponent {
    fun inject(reposPresenter: ReposPresenter)
}