package geek.libraris.mvptest

import geek.libraris.mvptest.model.GithubUser
import geek.libraris.mvptest.ui.one_user.OneUserFragment
import geek.libraris.mvptest.ui.users.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class OneUserScreen(val user : GithubUser) : SupportAppScreen() {
        override fun getFragment() = OneUserFragment.newInstance(user)
    }
}
