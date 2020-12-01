package geek.libraris.GithubClient.repos.presenter.list

interface IReposListPresenter<V : IRepoItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IRepoListPresenter : IReposListPresenter<RepoItemView> {
}