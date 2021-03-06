package geek.libraris.githubclient.users.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import geek.libraris.githubclient.*
import geek.libraris.githubclient.users.model.retrofit.RetrofitGithubUsersRepo
import geek.libraris.githubclient.users.model.retrofit.UsersApiHolder
import geek.libraris.githubclient.users.presenter.UsersPresenter
import geek.libraris.githubclient.App
import geek.libraris.githubclient.common.BackButtonListener
import geek.libraris.githubclient.common.dagger.RepositorySubcomponent
import geek.libraris.githubclient.common.dagger.UserSubcomponent
import geek.libraris.githubclient.users.views.UsersView
import geek.libraris.githubclient.common.glide.GlideImageLoader
import geek.libraris.githubclient.common.network.AndroidNetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.RoomUserCache
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    var userSubcomponent: UserSubcomponent? = null

    val presenter: UsersPresenter by moxyPresenter {
        userSubcomponent = App.instance.initUserSubcomponent()
        UsersPresenter().apply {
            userSubcomponent?.inject(this)
        }
    }

    var adapter: UsersRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_users, null)

    override fun init() {
        rv_users.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter).apply {
            App.instance.appComponent.inject(this)

        }
        rv_users.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun release() {
        userSubcomponent = null
        App.instance.releaseUserSubcomponent()
    }

    override fun backPressed() = presenter.backPressed()

}
