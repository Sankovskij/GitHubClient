package geek.libraris.githubclient.common.dagger

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.App
import geek.libraris.githubclient.common.network.AndroidNetworkStatus
import geek.libraris.githubclient.common.network.INetworkStatus
import geek.libraris.githubclient.repos.model.retrofit.IReposSourse
import geek.libraris.githubclient.users.model.retrofit.IUsersSource
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = "https://api.github.com/"

    @Provides
    fun usersApi(@Named("baseUrl") baseUrl: String, gson: Gson): IUsersSource = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IUsersSource::class.java)


    @Provides
    fun reposApi(@Named("baseUrl") baseUrl: String, gson: Gson): IReposSourse = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IReposSourse::class.java)

    @Singleton
    @Provides
    fun gson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()


    @Singleton
    @Provides
    fun networkStatus(app: App): INetworkStatus = AndroidNetworkStatus(app)
}
