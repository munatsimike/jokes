package nl.project.jokes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import nl.project.jokes.model.Joke

@Database(entities = [Joke::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val jokeDao: JokeDao
}