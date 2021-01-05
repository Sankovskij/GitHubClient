package geek.libraris.githubclient.common.dagger.modules

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import geek.libraris.githubclient.common.glide.GlideImageLoader
import geek.libraris.githubclient.common.glide.IImageLoader
import geek.libraris.githubclient.common.network.INetworkStatus
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun imageLoader():
            IImageLoader<ImageView> = GlideImageLoader()
}