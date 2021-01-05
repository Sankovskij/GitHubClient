package geek.libraris.githubclient.common.dagger

import dagger.Component
import geek.libraris.githubclient.common.dagger.modules.*
import geek.libraris.githubclient.main.presenter.MainPresenter
import geek.libraris.githubclient.main.ui.MainActivity
import geek.libraris.githubclient.repo_info.presenter.RepoInfoPresenter
import geek.libraris.githubclient.repo_info.ui.RepoInfoFragment
import geek.libraris.githubclient.repos.presenter.ReposPresenter
import geek.libraris.githubclient.users.presenter.UsersPresenter
import geek.libraris.githubclient.users.ui.UsersRVAdapter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class,
        ApiModule::class,
        ImageModule::class,
        ThreadModule::class
    ]
)

interface AppComponent {
    fun userSubcomponent() : UserSubcomponent
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(repoInfoPresenter: RepoInfoPresenter)
    fun inject(repoInfoFragment: RepoInfoFragment)
    fun inject(usersRVAdapter: UsersRVAdapter)


}


