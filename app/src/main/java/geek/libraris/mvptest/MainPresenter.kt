package geek.libraris.mvptest


class MainPresenter(val view: MainView) {
    val model = CountersModel()


    fun counterClick1() {
        val nextValue = model.next(0)
        view.setButtonText1(nextValue.toString())
    }

    fun counterClick2() {
        val nextValue = model.next(1)
        view.setButtonText2(nextValue.toString())
    }

    fun counterClick3() {
        val nextValue = model.next(2)
        view.setButtonText3(nextValue.toString())
    }
}
//такое вот задание
