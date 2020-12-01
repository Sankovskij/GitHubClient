package geek.libraris.GithubClient.repo_info.presenter

import geek.libraris.GithubClient.repo_info.views.RepoInfoView
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
