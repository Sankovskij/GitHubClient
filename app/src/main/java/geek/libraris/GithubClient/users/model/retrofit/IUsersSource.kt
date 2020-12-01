package geek.libraris.GithubClient.users.model.retrofit

import geek.libraris.GithubClient.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface IUsersSource {
        @GET("/users")
        fun getUsers(): Single<List<GithubUser>>

}