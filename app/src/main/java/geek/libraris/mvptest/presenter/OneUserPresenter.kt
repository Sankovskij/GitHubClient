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

class OneUserPresenter(val usersRepo: GithubUsersRepo, val router: Router, val user: Int?  ): MvpPresenter<OneUserView>() {

    var githubUser : GithubUser? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() : Observable<GithubUser>? {
        return user?.let {
            usersRepo.getUsers()
                .take(it.toLong()+1)
        }
    }





    fun backPressed(): Boolean {
        router.exit()
        return true
    }


    val oneUserUserObserver = object : Observer<GithubUser> {
        var disposable: Disposable? = null

        override fun onComplete() {
            println("onComplete")
        }

        override fun onSubscribe(d: Disposable?) {
            disposable = d
            println("onSubscribe")
        }

        override fun onNext(s: GithubUser?) {
            if (s != null) {
                githubUser = s
            }
        }

        override fun onError(e: Throwable?) {
            println("onError: ${e?.message}")
        }
    }

}


//такое вот задание
