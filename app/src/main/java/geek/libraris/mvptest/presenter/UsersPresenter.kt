package geek.libraris.mvptest.presenter

import geek.libraris.mvptest.Screens
import geek.libraris.mvptest.model.GithubUser
import geek.libraris.mvptest.model.GithubUsersRepo
import geek.libraris.mvptest.model.repo.IGithubUsersRepo
import geek.libraris.mvptest.presenter.list.IUserListPresenter
import geek.libraris.mvptest.views.UserItemView
import geek.libraris.mvptest.views.UsersView
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter(val mainThreadScheduler: Scheduler, val usersRepo: IGithubUsersRepo, val router: Router): MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            user.login?.let { view.setLogin(it) }
            user.avatarUrl?.let {view.loadAvatar(it)}



        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(Screens.OneUserScreen(user))
        }

    }

    fun loadData() {
        usersRepo.getUsers()
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(repos)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}


