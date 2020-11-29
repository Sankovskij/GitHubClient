package geek.libraris.mvptest.ui.one_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import geek.libraris.mvptest.*
import geek.libraris.mvptest.model.GithubUser
import geek.libraris.mvptest.model.GithubUsersRepo
import geek.libraris.mvptest.presenter.OneUserPresenter
import geek.libraris.mvptest.presenter.UsersPresenter
import geek.libraris.mvptest.ui.App
import geek.libraris.mvptest.ui.BackButtonListener
import geek.libraris.mvptest.views.OneUserView
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_one_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class OneUserFragment : MvpAppCompatFragment(), OneUserView, BackButtonListener {
    companion object {
        fun newInstance(data: GithubUser): OneUserFragment {
            val oneUserFragment = OneUserFragment()
            val bundle = Bundle()
            bundle.putParcelable("USER" , data)
            oneUserFragment.arguments = bundle
            return oneUserFragment
        }
    }



    val user = arguments?.getParcelable<GithubUser>("USER")
    val presenter: OneUserPresenter by moxyPresenter { OneUserPresenter(App.instance.router, user) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_one_user, null)

    override fun init() {

    }

    override fun backPressed() = presenter.backPressed()
}

