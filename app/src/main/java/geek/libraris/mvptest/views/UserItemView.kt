package geek.libraris.mvptest.views

import geek.libraris.mvptest.presenter.list.UIItemView

interface UserItemView : UIItemView {
        fun setLogin(text: String)
}