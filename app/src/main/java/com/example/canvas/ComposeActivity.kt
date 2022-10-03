package com.example.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.canvas.details.DetailsContent
import com.example.canvas.details.Hero
import com.example.canvas.ui.theme.CanvasTheme
import org.w3c.dom.Text

class ComposeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    DetailsContent(
                        selectedHero = Hero(
                            id = 1,
                            name = "Naruto",
                            image = "",
                            about = "Merhabalar looooa sdfasd fas df asdf sadf asd fsad fsadf asd fasdf sda fsadfsad fasdf asd fasdfasdfasdfasd fasd fasdf asdfsadf sad fasd fasd fasd fasdfasdfasdf sadfasdfasd fasd fasdfasdfasdfasdfasdfasdfasdfasdfadsf sadf asdf asdf asdf asdf asdfasd fasd fasd fasdfasd fasd fasdf asdf asdf asd",
                            rating = 4.5,
                            power = 0,
                            month = "Oct",
                            day = "1st",
                            family = listOf("Minato", "Kushina", "Boruto", "Himawari"),
                            abilities = listOf("Sage Mode", "Shadow Clone", "Rasengan"),
                            natureTypes = listOf("Earth", "Wind")
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CanvasTheme {
        DetailsContent(
            selectedHero = Hero(
                id = 1,
                name = "Naruto",
                image = "",
                about = "Merhabalar looooa sdfasd fas df asdf sadf asd fsad fsadf asd fasdf sda fsadfsad fasdf asd fasdfasdfasdfasd fasd fasdf asdfsadf sad fasd fasd fasd fasdfasdfasdf sadfasdfasd fasd fasdfasdfasdfasdfasdfasdfasdfasdfadsf sadf asdf asdf asdf asdf asdfasd fasd fasd fasdfasd fasd fasdf asdf asdf asd",
                rating = 4.5,
                power = 0,
                month = "Oct",
                day = "1st",
                family = listOf("Minato", "Kushina", "Boruto", "Himawari"),
                abilities = listOf("Sage Mode", "Shadow Clone", "Rasengan"),
                natureTypes = listOf("Earth", "Wind")
            )
        )    }
}
