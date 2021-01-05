package geek.libraris.githubclient

import android.app.Application
import geek.libraris.githubclient.common.dagger.AppComponent
import geek.libraris.githubclient.common.dagger.modules.AppModule
import geek.libraris.githubclient.common.dagger.DaggerAppComponent
import geek.libraris.githubclient.common.dagger.RepositorySubcomponent
import geek.libraris.githubclient.common.dagger.UserSubcomponent

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set

    var userSubcomponent: UserSubcomponent? = null
        private set

    var repositorySubcomponent: RepositorySubcomponent? = null
        private set


    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initUserSubcomponent() = appComponent.userSubcomponent().also {
        userSubcomponent = it
    }
    fun releaseUserSubcomponent() {
        userSubcomponent = null
    }

    fun initRepositorySubcomponent() = userSubcomponent?.repositorySubcomponent().also{
        repositorySubcomponent = it
    }
    fun releaseRepositorySubcomponent() {
        repositorySubcomponent  = null
    }
}

