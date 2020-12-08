package geek.libraris.githubclient.common.dagger

import dagger.Subcomponent
import geek.libraris.githubclient.common.dagger.modules.UserModule
import geek.libraris.githubclient.common.dagger.scopes.UserScope
import geek.libraris.githubclient.users.presenter.UsersPresenter
import geek.libraris.githubclient.users.ui.UsersRVAdapter

@UserScope
@Subcomponent(
    modules = [
        UserModule::class
]
)


interface UserSubcomponent {
        fun repositorySubcomponent(): RepositorySubcomponent
        fun inject(usersPresenter: UsersPresenter)
        fun inject(usersRVAdapter: UsersRVAdapter)



}