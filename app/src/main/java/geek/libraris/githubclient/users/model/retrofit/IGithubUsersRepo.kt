package geek.libraris.githubclient.users.model.retrofit

import geek.libraris.githubclient.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}
