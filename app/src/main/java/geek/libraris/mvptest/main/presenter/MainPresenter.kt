package geek.libraris.mvptest.main.presenter

import geek.libraris.mvptest.common.Screens
import geek.libraris.mvptest.main.views.MainView
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





