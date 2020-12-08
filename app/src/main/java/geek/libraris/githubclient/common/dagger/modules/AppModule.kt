package geek.libraris.githubclient.common.dagger.modules

import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App {
        return app
    }

}