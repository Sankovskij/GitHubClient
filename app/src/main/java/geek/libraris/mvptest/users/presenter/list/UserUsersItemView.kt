package geek.libraris.mvptest.users.presenter.list

import geek.libraris.mvptest.users.presenter.list.UIUsersItemView

interface UserUsersItemView : UIUsersItemView {
        fun setLogin(text: String)
        fun loadAvatar(url: String)
}