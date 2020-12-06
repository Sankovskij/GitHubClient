package geek.libraris.githubclient.common.dagger

import dagger.Component
import geek.libraris.githubclient.main.presenter.MainPresenter
import geek.libraris.githubclient.main.ui.MainActivity
import geek.libraris.githubclient.repo_info.presenter.RepoInfoPresenter
import geek.libraris.githubclient.repos.presenter.ReposPresenter
import geek.libraris.githubclient.repos.ui.ReposFragment
import geek.libraris.githubclient.users.presenter.UsersPresenter
import geek.libraris.githubclient.users.ui.UsersFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        CacheModule::class,
        ApiModule::class,
        RepoModule::class,
        ThreadModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(reposPresenter: ReposPresenter)
    fun inject(repoInfoPresenter: RepoInfoPresenter)

}


