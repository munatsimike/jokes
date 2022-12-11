package nl.project.jokes.state

import nl.project.jokes.model.Joke

sealed class NetworkState {
    object NotLoading : NetworkState()
    object Loading : NetworkState()
    class NetworkError(val error: String) : NetworkState()
    class NetworkSuccess(val jokes: List<Joke>) : NetworkState()
}
