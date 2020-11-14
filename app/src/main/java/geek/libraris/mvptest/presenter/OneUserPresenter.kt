package geek.libraris.mvptest.presenter

import geek.libraris.mvptest.model.GithubUser
import geek.libraris.mvptest.model.GithubUsersRepo
import geek.libraris.mvptest.views.OneUserView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class OneUserPresenter(val usersRepo: GithubUsersRepo, val router: Router, val user: Int?  ): MvpPresenter<OneUserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() : GithubUser?
        = user?.let { usersRepo.getUsers()[it] }





    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}


//такое вот задание
