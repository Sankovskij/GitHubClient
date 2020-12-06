package geek.libraris.githubclient.common

import geek.libraris.githubclient.repo_info.ui.RepoInfoFragment
import geek.libraris.githubclient.repos.model.entity.GithubRepository
import geek.libraris.githubclient.users.model.entity.GithubUser
import geek.libraris.githubclient.repos.ui.ReposFragment
import geek.libraris.githubclient.users.ui.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class ReposScreen(val user : GithubUser) : SupportAppScreen() {
        override fun getFragment() = ReposFragment.newInstance(user)
    }

    class RepoInfoScreen(val user : GithubUser?, val repo : GithubRepository?) : SupportAppScreen() {
        override fun getFragment() = RepoInfoFragment.newInstance(repo, user)
    }
}
