package nl.project.jokes.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import nl.project.jokes.data.remote.JokeService
import nl.project.jokes.model.JokeApiResponse
import javax.inject.Inject

class JokeRepository @Inject constructor(var jokeService: JokeService) {
    suspend fun getJokes(): Flow<JokeApiResponse> = flowOf(jokeService.getJokes())
}