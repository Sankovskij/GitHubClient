package geek.libraris.mvptest.repos.presenter.list

import geek.libraris.mvptest.repos.presenter.list.IRepoItemView

interface RepoItemView: IRepoItemView {
    fun setName(text: String)
}
