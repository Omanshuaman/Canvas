package com.example.canvas

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.canvas.details.DetailsContent
import com.example.canvas.details.DetailsViewModel
import com.example.canvas.details.Hero
import com.example.canvas.details.UiEvent
import com.example.canvas.ui.theme.CanvasTheme
import com.example.canvas.util.Constants.BASE_URL
import com.example.canvas.util.PaletteGenerator.convertImageUrlToBitmap
import com.example.canvas.util.PaletteGenerator.extractColorsFromBitmap
import kotlinx.coroutines.flow.collectLatest
import org.w3c.dom.Text
import androidx.lifecycle.ViewModelProviders
import coil.annotation.ExperimentalCoilApi
import androidx.hilt.navigation.compose.hiltViewModel

class ComposeActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            CanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DetailsScreen()
                }
            }
        }
    }

    @ExperimentalCoilApi
    @ExperimentalMaterialApi
    @Composable
    fun DetailsScreen(
        detailsViewModel: DetailsViewModel = hiltViewModel()
    ) {

        val colorPalette by detailsViewModel.colorPalette
        Log.d("TAG", "DetailsScreen: " + colorPalette)

        if (colorPalette.isNotEmpty()) {
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
                ), colors = colorPalette
            )
        } else {
            detailsViewModel.generateColorPalette()

        }

        val context = LocalContext.current

        LaunchedEffect(key1 = true) {

            val bitmap = convertImageUrlToBitmap(
                imageUrl = "$BASE_URL/images/sasuke.jpg",
                context = context
            )

            if (bitmap != null) {
                detailsViewModel.setColorPalette(
                    colors = extractColorsFromBitmap(bitmap = bitmap)
                )

            }
        }

    }
}

