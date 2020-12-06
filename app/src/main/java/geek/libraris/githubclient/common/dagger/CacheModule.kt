package geek.libraris.githubclient.common.dagger

import androidx.room.Room
import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.App
import geek.libraris.githubclient.common.room.*
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App): Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()


    @Singleton
    @Provides
    fun usersCache(): IUserCache = RoomUserCache()


@Singleton
@Provides
fun reposCache(): IRepositoriesCache = RoomRepositoriesCache()
}
