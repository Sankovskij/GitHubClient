package geek.libraris.githubclient.main.ui

import android.content.Context
import android.os.Bundle
import geek.libraris.githubclient.main.presenter.MainPresenter
import geek.libraris.githubclient.R
import geek.libraris.githubclient.App
import geek.libraris.githubclient.common.BackButtonListener
import geek.libraris.githubclient.common.room.Database
import geek.libraris.githubclient.main.views.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import java.lang.RuntimeException
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    val presenter: MainPresenter by moxyPresenter  {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.appComponent.inject(this)

       /* try {
            Database.getInstance()
        } catch (e : RuntimeException) {
            Database.create(applicationContext)
        }*/
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}

