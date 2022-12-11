package nl.project.jokes.data

import nl.project.jokes.data.local.JokeDao
import nl.project.jokes.data.remote.JokeService
import javax.inject.Inject

class JokeRepository @Inject constructor(
    private val jokeService: JokeService, private val jokeDao: JokeDao
) {
    val joke = jokeDao.getJokes()
    suspend fun fetchJokes() {
        jokeDao.insertJokes(jokeService.getJokes().jokes)
    }
}