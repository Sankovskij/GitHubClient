package geek.libraris.mvptest.repos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import geek.libraris.mvptest.R
import geek.libraris.mvptest.repos.presenter.list.IRepoListPresenter
import geek.libraris.mvptest.repos.presenter.list.RepoItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repo.view.*

class ReposRVAdapter(val presenter: IRepoListPresenter) : RecyclerView.Adapter<ReposRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer, RepoItemView {

        override var pos = -1

        override fun setName(text: String)= with(containerView) {
            tv_name.text = text
        }



    }

}
