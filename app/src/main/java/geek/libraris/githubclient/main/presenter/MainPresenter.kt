package geek.libraris.githubclient.main.presenter

import geek.libraris.githubclient.common.Screens
import geek.libraris.githubclient.main.views.MainView
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





