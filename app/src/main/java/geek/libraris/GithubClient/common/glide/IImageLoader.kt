package geek.libraris.GithubClient.common.glide

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}
