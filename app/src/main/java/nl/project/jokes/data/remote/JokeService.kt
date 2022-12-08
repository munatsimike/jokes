package nl.project.jokes.data.remote

import nl.project.jokes.model.JokeApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {

    @GET("/joke/Any")
    suspend fun getJokes(@Query("amount") amount: Int = 10): JokeApiResponse
}