package geek.libraris.githubclient.repos.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import geek.libraris.githubclient.*
import geek.libraris.githubclient.users.model.entity.GithubUser
import geek.libraris.githubclient.repos.presenter.ReposPresenter
import geek.libraris.githubclient.repos.views.ReposView
import geek.libraris.githubclient.App
import geek.libraris.githubclient.common.BackButtonListener
import geek.libraris.githubclient.common.dagger.RepositorySubcomponent
import geek.libraris.githubclient.common.network.AndroidNetworkStatus
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.common.room.RoomRepositoriesCache
import geek.libraris.githubclient.repos.model.retrofit.ReposApiHolder
import geek.libraris.githubclient.repos.model.retrofit.RetrofitGithubUserRepos
import geek.libraris.githubclient.users.ui.UsersFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_repos.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment : MvpAppCompatFragment(), ReposView, BackButtonListener {
    companion object {
        fun newInstance(data: GithubUser) = ReposFragment().apply {
            val bundle = Bundle()
            bundle.putParcelable("USER" , data)
            this.arguments = bundle
            return this
        }
    }

    var repositorySubcomponent: RepositorySubcomponent? = null

    val presenter: ReposPresenter by moxyPresenter {
        repositorySubcomponent = App.instance.initRepositorySubcomponent()
        ReposPresenter(arguments?.getParcelable("USER") as GithubUser?).apply {
            repositorySubcomponent?.inject(this)
        }
    }

    var adapter: ReposRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_repos, null)

    override fun init() {
        rv_repos.layoutManager = LinearLayoutManager(context)
        adapter = ReposRVAdapter(presenter.reposListPresenter).apply {
        }
        rv_repos.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun release() {
        repositorySubcomponent = null
        App.instance.releaseRepositorySubcomponent()
    }


    override fun backPressed() = presenter.backPressed()
}

