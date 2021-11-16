package com.anuchito.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.anuchito.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                ScreenContent()
            }
        }
    }
}

@Composable
fun App(content: @Composable () -> Unit) {
    JetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun ScreenContent() {
    Column {
        Greeting(name = "AnuchitO!!!")
        Divider()
        Greeting(name = "Nong!!")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Voila $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Greeting("AnuchitO!")
    }
}