package geek.libraris.mvptest.repos.model.retrofit

import geek.libraris.mvptest.repos.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Single

interface IGithubUserRepos {
    fun getRepos(login: String?): Single<List<GithubUserRepo>>
}
