package geek.libraris.GithubClient.users.model.retrofit

import geek.libraris.GithubClient.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}
