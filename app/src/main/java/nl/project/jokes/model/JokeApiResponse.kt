package nl.project.jokes.model

data class JokeApiResponse(
    val amount: Int,
    val error: Boolean,
    val jokes: List<Joke>
)