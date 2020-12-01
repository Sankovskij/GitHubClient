package geek.libraris.mvptest.users.model.retrofit

import geek.libraris.mvptest.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface IUsersSource {
        @GET("/users")
        fun getUsers(): Single<List<GithubUser>>

}