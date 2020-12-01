package geek.libraris.githubclient.repos.model.retrofit

import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUserRepos(val api: IReposSourse): IGithubUserRepos {
    override fun getRepos(login: String?)=  api.loadRepos(login).subscribeOn(Schedulers.io())
    }


