package geek.libraris.githubclient.common.room

import geek.libraris.githubclient.users.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

class RoomUserCache() : IUserCache {
    override fun findInCache(db: Database): Single<List<GithubUser>> = Single.fromCallable {
        db.userDao.getAll().map { roomUser ->
            GithubUser(roomUser.id, roomUser.login, roomUser.avatarUrl, roomUser.reposUrl)
        }
    }

    override fun insertToCache(users: List<GithubUser>, db: Database) {
        val roomUsers = users.map { user -> RoomGithubUser(user.id ?: "", user.login ?: "", user.avatarUrl ?: "", user.reposUrl ?: "") }
        db.userDao.insert(roomUsers)
    }
}
