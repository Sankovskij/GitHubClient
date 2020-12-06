package geek.libraris.githubclient

import android.app.Application
import geek.libraris.githubclient.common.dagger.AppComponent
import geek.libraris.githubclient.common.dagger.AppModule
import geek.libraris.githubclient.common.dagger.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}

