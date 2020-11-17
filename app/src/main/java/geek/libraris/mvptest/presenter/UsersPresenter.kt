package geek.libraris.mvptest.presenter

import geek.libraris.mvptest.Screens
import geek.libraris.mvptest.model.GithubUser
import geek.libraris.mvptest.model.GithubUsersRepo
import geek.libraris.mvptest.presenter.list.IUserListPresenter
import geek.libraris.mvptest.views.UserItemView
import geek.libraris.mvptest.views.UsersView
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router): MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->

            router.navigateTo(Screens.OneUserScreen(itemView.pos))

        }
    }

    fun loadData() {
        val users =  usersRepo.getUsers()
        users.subscribe(githubUserObserver)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    val githubUserObserver = object : Observer<GithubUser> {
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
                usersListPresenter.users.add(s)
            }
        }

        override fun onError(e: Throwable?) {
            println("onError: ${e?.message}")
        }
    }


}




//такое вот задание
