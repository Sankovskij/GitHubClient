package geek.libraris.mvptest.model.repo.retrofit

import geek.libraris.mvptest.model.IDataSource
import geek.libraris.mvptest.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(val api: IDataSource): IGithubUsersRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())
}
