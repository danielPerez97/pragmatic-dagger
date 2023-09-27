package dev.danperez.typicode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import dev.danperez.typicode.ui.theme.TypicodeExampleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject lateinit var typicodeService: TypicodeService
    var text by mutableStateOf("Hello!")

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as TypicodeApplication).typicodeAppComponent.inject(this)
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            text = typicodeService.getPost(1).string()
        }

        setContent {
            TypicodeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text)
                }
            }
        }
    }
}