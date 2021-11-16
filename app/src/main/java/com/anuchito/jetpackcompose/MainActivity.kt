package com.anuchito.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun ScreenContent(names: List<String> = listOf("AnuchitO!!", "Nong")) {
    var count by remember {
        mutableStateOf(0)
    }
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider()
        }
        Counter(
            count = count,
            updateCount = { newCount -> count = newCount }
        )
        if (count >5) {
            Greeting(name = "Awesome!!! $count")
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I've been clicked $count times.")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Voila $name",
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    App {
        ScreenContent()
    }
}