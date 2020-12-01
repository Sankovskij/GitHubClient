package geek.libraris.mvptest.common

import geek.libraris.mvptest.repo_info.ui.RepoInfoInfoFragment
import geek.libraris.mvptest.repos.model.entity.GithubUserRepo
import geek.libraris.mvptest.users.model.entity.GithubUser
import geek.libraris.mvptest.repos.ui.ReposFragment
import geek.libraris.mvptest.users.ui.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class ReposScreen(val user : GithubUser) : SupportAppScreen() {
        override fun getFragment() = ReposFragment.newInstance(user)
    }

    class RepoInfoScreen(val user : GithubUser?, val repo : GithubUserRepo?) : SupportAppScreen() {
        override fun getFragment() = RepoInfoInfoFragment.newInstance(repo, user)
    }
}
