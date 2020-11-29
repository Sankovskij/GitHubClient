package geek.libraris.mvptest.views.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}
