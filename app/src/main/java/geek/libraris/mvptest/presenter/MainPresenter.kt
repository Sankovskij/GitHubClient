package geek.libraris.mvptest.presenter

import geek.libraris.mvptest.Screens
import geek.libraris.mvptest.views.MainView
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





