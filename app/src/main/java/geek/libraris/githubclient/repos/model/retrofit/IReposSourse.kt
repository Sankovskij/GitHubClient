package geek.libraris.githubclient.repos.model.retrofit

import geek.libraris.githubclient.repos.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface IReposSourse {
        @GET("users/{login}/repos")
        fun loadRepos(@Path("login") login: String?): Single<List<GithubUserRepo>>
}