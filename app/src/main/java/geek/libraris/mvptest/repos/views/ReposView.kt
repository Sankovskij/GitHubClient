package geek.libraris.mvptest.repos.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ReposView : MvpView {
    fun init()
    fun updateList()

}
