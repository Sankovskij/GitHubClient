package geek.libraris.mvptest.presenter.list

import geek.libraris.mvptest.views.UserItemView

interface IListPresenter<V : UIItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>
