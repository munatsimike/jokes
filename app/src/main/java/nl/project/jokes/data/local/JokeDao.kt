package nl.project.jokes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import nl.project.jokes.model.Joke

@Dao
interface JokeDao {
    @Query("SELECT * FROM JOKE_TABLE")
    fun getJokes(): Flow<List<Joke>>

    @Insert
   suspend fun insertJokes(jokes: List<Joke>)
}