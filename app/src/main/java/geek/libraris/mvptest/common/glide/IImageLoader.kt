package geek.libraris.mvptest.common.glide

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}
