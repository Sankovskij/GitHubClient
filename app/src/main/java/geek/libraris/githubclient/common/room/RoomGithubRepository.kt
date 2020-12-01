package geek.libraris.githubclient.common.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose


@Entity(
        foreignKeys = [ForeignKey(
            entity = RoomGithubUser::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )]
    )
    data class RoomGithubRepository(
    @PrimaryKey var id: String,
    val name: String? = null,
    val description: String? = null,
    val size: Int? = null,
    val language: String? = null,
    var userId: String
    )
