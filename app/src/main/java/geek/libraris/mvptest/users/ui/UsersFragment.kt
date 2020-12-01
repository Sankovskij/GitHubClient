package geek.libraris.mvptest.users.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import geek.libraris.mvptest.*
import geek.libraris.mvptest.users.model.retrofit.RetrofitGithubUsersRepo
import geek.libraris.mvptest.users.model.retrofit.UsersApiHolder
import geek.libraris.mvptest.users.presenter.UsersPresenter
import geek.libraris.mvptest.App
import geek.libraris.mvptest.common.BackButtonListener
import geek.libraris.mvptest.users.views.UsersView
import geek.libraris.mvptest.common.glide.GlideImageLoader
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter { UsersPresenter(AndroidSchedulers.mainThread(), RetrofitGithubUsersRepo(
        UsersApiHolder.api), App.instance.router)
    }


    var adapter: UsersRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_users, null)

    override fun init() {
        rv_users.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())
        rv_users.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}
