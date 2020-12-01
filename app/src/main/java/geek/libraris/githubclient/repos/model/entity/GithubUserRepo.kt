package geek.libraris.githubclient.repos.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUserRepo(
    @Expose val id: String? = null,
    @Expose val name: String? = null,
    @Expose val description: String? = null,
    @Expose val size: Int? = null,
    @Expose val language: String? = null

) : Parcelable

