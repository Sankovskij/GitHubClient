package geek.libraris.githubclient.users.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import geek.libraris.githubclient.R
import geek.libraris.githubclient.users.presenter.list.IUserListPresenter
import geek.libraris.githubclient.users.presenter.list.UserUsersItemView
import geek.libraris.githubclient.common.glide.IImageLoader
import io.reactivex.rxjava3.core.Scheduler
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_user.view.*
import javax.inject.Inject

class UsersRVAdapter(val presenter: IUserListPresenter) : RecyclerView.Adapter<UsersRVAdapter.ViewHolderUsers>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderUsers(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolderUsers, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }


    inner class ViewHolderUsers(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer, UserUsersItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(containerView) {
            tv_login.text = text
        }
        override fun loadAvatar(url: String) = with(containerView) { imageLoader.loadInto(url, iv_avatar) }
    }

}
