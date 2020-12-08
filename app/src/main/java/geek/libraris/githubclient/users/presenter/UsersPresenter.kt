package geek.libraris.githubclient.users.presenter

import geek.libraris.githubclient.common.Screens
import geek.libraris.githubclient.users.model.entity.GithubUser
import geek.libraris.githubclient.users.model.retrofit.IGithubUsersRepo
import geek.libraris.githubclient.users.presenter.list.IUserListPresenter
import geek.libraris.githubclient.users.presenter.list.UserUsersItemView
import geek.libraris.githubclient.users.views.UsersView
import io.reactivex.rxjava3.core.Scheduler
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class UsersPresenter(): MvpPresenter<UsersView>() {

    @Inject
    lateinit var mainThreadScheduler: Scheduler
    @Inject
    lateinit var usersRepo: IGithubUsersRepo
    @Inject
    lateinit var router: Router


    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserUsersItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserUsersItemView) {
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
            router.navigateTo(Screens.ReposScreen(user))
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

    override fun onDestroy() {
        super.onDestroy()
        viewState.release()
    }

}


