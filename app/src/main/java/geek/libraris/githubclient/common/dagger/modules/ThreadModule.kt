package geek.libraris.githubclient.common.dagger.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
class ThreadModule {

    @Provides
    fun mainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()
}