package geek.libraris.GithubClient.main.presenter

import geek.libraris.GithubClient.common.Screens
import geek.libraris.GithubClient.main.views.MainView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(val router: Router): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen())
        }

    fun backClicked() {
        router.exit()
    }

}





