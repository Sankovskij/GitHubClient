package geek.libraris.githubclient.common.room
import geek.libraris.githubclient.repos.model.entity.GithubRepository
import io.reactivex.rxjava3.core.Single

interface IRepositoriesCache {
    fun findInCache(login: String?, db : Database): Single<List<GithubRepository>>
    fun insertToCache(login: String?, repositories : List<GithubRepository>, db : Database)
}