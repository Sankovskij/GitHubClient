package geek.libraris.githubclient.common.glide

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}
