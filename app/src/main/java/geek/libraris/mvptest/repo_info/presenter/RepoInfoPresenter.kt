package geek.libraris.mvptest.repo_info.presenter

import geek.libraris.mvptest.repo_info.views.RepoInfoView
import geek.libraris.mvptest.repos.views.ReposView
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class RepoInfoPresenter(val router: Router) : MvpPresenter<RepoInfoView>()  {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

        fun backPressed(): Boolean {
            router.exit()
            return true
        }
    }
