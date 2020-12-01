package geek.libraris.mvptest.users.model.retrofit

import geek.libraris.mvptest.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}
