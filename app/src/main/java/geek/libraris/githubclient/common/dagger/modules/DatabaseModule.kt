package geek.libraris.githubclient.common.dagger.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.App
import geek.libraris.githubclient.common.room.*
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(app: App): Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()


}
