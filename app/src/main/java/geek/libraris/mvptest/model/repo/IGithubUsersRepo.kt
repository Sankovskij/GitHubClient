package geek.libraris.mvptest.model.repo

import geek.libraris.mvptest.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}
