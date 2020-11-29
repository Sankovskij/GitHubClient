package geek.libraris.mvptest.presenter

import geek.libraris.mvptest.model.GithubUser
import geek.libraris.mvptest.model.GithubUsersRepo
import geek.libraris.mvptest.views.OneUserView
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_one_user.*
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class OneUserPresenter(val router: Router, val user: GithubUser?) : MvpPresenter<OneUserView>()  {


        override fun onFirstViewAttach() {
            super.onFirstViewAttach()


        }

        fun backPressed(): Boolean {
            router.exit()
            return true
        }
    }
