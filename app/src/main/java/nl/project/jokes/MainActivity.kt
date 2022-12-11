package nl.project.jokes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import nl.project.jokes.state.NetworkState
import nl.project.jokes.ui.theme.JokesTheme
import nl.project.jokes.viewModel.JokeViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JokesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Jokes()
                }
            }
        }
    }
}

@Composable
fun Jokes(jokesViewModel: JokeViewModel = hiltViewModel()) {
    val jokes by jokesViewModel.jokes.collectAsState()
    LazyColumn {
        when (jokes) {
            NetworkState.Loading -> {
                item {
                    CircularProgressIndicator()
                }
            }
            is NetworkState.NetworkError -> {}
            is NetworkState.NetworkSuccess -> {
                val data = jokes as NetworkState.NetworkSuccess
                items(data.jokes) { joke ->
                    joke.joke?.let {
                        Text(text = it)
                    } ?: joke.delivery?.let {
                        Text(text = it)
                    }
                }
            }
            NetworkState.NotLoading -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JokesTheme {

    }
}