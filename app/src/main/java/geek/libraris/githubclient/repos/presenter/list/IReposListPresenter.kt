package geek.libraris.githubclient.repos.presenter.list

interface IReposListPresenter<V : IRepoItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IRepoListPresenter : IReposListPresenter<RepoItemView> {
}