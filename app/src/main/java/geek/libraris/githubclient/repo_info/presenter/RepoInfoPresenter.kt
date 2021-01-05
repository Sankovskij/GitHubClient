package geek.libraris.githubclient.repo_info.presenter

import geek.libraris.githubclient.repo_info.views.RepoInfoView
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RepoInfoPresenter() : MvpPresenter<RepoInfoView>()  {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

        fun backPressed(): Boolean {
            router.exit()
            return true
        }
    }
