package geek.libraris.mvptest.repos.model.retrofit

import geek.libraris.mvptest.repos.model.entity.GithubUserRepo
import geek.libraris.mvptest.repos.model.retrofit.IGithubUserRepos
import geek.libraris.mvptest.repos.model.retrofit.IReposSourse
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUserRepos(val api: IReposSourse): IGithubUserRepos {
    override fun getRepos(login: String?)=  api.loadRepos(login).subscribeOn(Schedulers.io())
    }

