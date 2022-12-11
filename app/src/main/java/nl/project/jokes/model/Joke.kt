package nl.project.jokes.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "joke_table")
data class Joke(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val category: String,
    val delivery: String?,
    val flags: Flags,
    val joke: String?,
    val lang: String,
    val safe: Boolean,
    val setup: String?,
    val type: String
) : Serializable