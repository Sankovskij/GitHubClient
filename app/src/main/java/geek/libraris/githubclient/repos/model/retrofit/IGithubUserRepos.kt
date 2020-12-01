package geek.libraris.githubclient.repos.model.retrofit

import geek.libraris.githubclient.repos.model.entity.GithubRepository
import io.reactivex.rxjava3.core.Single

interface IGithubUserRepos {
    fun getRepos(login: String?)
}
