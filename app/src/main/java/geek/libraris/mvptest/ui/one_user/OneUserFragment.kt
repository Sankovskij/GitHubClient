package geek.libraris.mvptest.ui.one_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import geek.libraris.mvptest.*
import geek.libraris.mvptest.model.GithubUsersRepo
import geek.libraris.mvptest.presenter.OneUserPresenter
import geek.libraris.mvptest.presenter.UsersPresenter
import geek.libraris.mvptest.ui.App
import geek.libraris.mvptest.ui.BackButtonListener
import geek.libraris.mvptest.views.OneUserView
import kotlinx.android.synthetic.main.fragment_one_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class OneUserFragment : MvpAppCompatFragment(), OneUserView, BackButtonListener {
    companion object {
        fun newInstance(data: Int): OneUserFragment {
            val oneUserFragment = OneUserFragment()
            val bundle = Bundle()
            bundle.putInt("USER" , data)
            oneUserFragment.arguments = bundle
            return oneUserFragment
        }
    }




    val presenter: OneUserPresenter by moxyPresenter { OneUserPresenter(GithubUsersRepo(), App.instance.router, arguments?.getInt("USER")) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_one_user, null)

    override fun init() {
        tv_login.text = presenter.loadData()?.login ?: "Юзер не дошёл до сюда"
    }




    override fun backPressed() = presenter.backPressed()
}

