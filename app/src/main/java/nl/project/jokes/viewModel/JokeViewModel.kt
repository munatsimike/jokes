package nl.project.jokes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import nl.project.jokes.data.JokeRepository
import nl.project.jokes.state.NetworkState
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokeRepository: JokeRepository
) : ViewModel() {

    private val _jokes: MutableStateFlow<NetworkState> = MutableStateFlow(NetworkState.NotLoading)
    val jokes: StateFlow<NetworkState> = _jokes

    init {
        getJokes()
    }

    private fun getJokes() {
        _jokes.value = NetworkState.Loading
        viewModelScope.launch {
            jokeRepository.getJokes().collectLatest {
                _jokes.value = NetworkState.NetworkSuccess(it.jokes)
            }
        }
    }
}
