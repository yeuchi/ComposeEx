package com.ctyeung.composeex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ctyeung.composeex.ui.theme.ComposeExTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class AnimateActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TopAppBar(title = {
                        Text("Animation")
                    },
                        navigationIcon = {
                            IconButton(onClick = {
                                onBackPressed()
                            }) {
                                Icon(
                                    Icons.Filled.ArrowBack,
                                    contentDescription = "back",
                                    tint = Color.White
                                )
                            }
                        }
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_account),
                            contentDescription = null // decorative element
                        )
                        //AnimateVisibility()
                        BikeScreen()
                    }
                }
            }
        }
    }
}

/*
https://proandroiddev.com/animate-with-jetpack-compose-animate-as-state-and-animation-specs-ffc708bb45f8
 */

enum class BikePosition  {
    Start, Finish;

}

@Preview
@Composable
fun BikeScreen() {
    var bikeState = remember { mutableStateOf(BikePosition.Start) }

    val offsetAnimation: Dp by animateDpAsState(
        if (bikeState.value == BikePosition.Start){ 5.dp }
        else { 200.dp },
    )
    val springAnimation: Dp by animateDpAsState(
        if (bikeState.value == BikePosition.Start){ 5.dp }
        else { 200.dp },spring(dampingRatio = Spring.DampingRatioLowBouncy)
    )
    val stiffAnimation: Dp by animateDpAsState(
        if (bikeState.value == BikePosition.Start){ 5.dp }
        else { 200.dp },spring(stiffness = Spring.StiffnessLow)
    )
    val tweenAnimation: Dp by animateDpAsState(
        if (bikeState.value == BikePosition.Start){ 5.dp }
        else { 200.dp }, tween(1000)
    )
    Box(
        modifier = Modifier
            .size(300.dp, 500.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_skateboarding),
            contentDescription = null,
            modifier = Modifier
                .height(90.dp)
                .absoluteOffset(x = offsetAnimation)
        )
        Image(
            painter = painterResource(R.drawable.ic_skateboarding),
            contentDescription = null,
            modifier = Modifier
                .offset(0.dp, 100.dp)
                .height(90.dp)
                .absoluteOffset(x = springAnimation)
        )
        Image(
            painter = painterResource(R.drawable.ic_skateboarding),
            contentDescription = null,
            modifier = Modifier
                .offset(0.dp, 200.dp)
                .height(90.dp)
                .absoluteOffset(x = stiffAnimation)
        )
        Image(
            painter = painterResource(R.drawable.ic_skateboarding),
            contentDescription = null,
            modifier = Modifier
                .offset(0.dp, 300.dp)
                .height(90.dp)
                .absoluteOffset(x = tweenAnimation)
        )
        Button(
            onClick = {
                bikeState.value = if (bikeState.value == BikePosition.Start)
                    BikePosition.Finish
                else
                    BikePosition.Start
            }, modifier = Modifier
                .offset(0.dp, 400.dp)
                .wrapContentSize(align = Alignment.Center)
        )
        {
            Text(text = "Ride")
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimateVisibility() {
    AnimatedVisibility(visible = true,
        enter = slideInVertically(
            // Start the slide from 40 (pixels) above where the content is supposed to go, to
            // produce a parallax effect
            initialOffsetY = { -40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()) {
        // Content that needs to appear/disappear goes here:
        Text(
            "Content to appear/disappear",
            Modifier
                .fillMaxWidth()
                .requiredHeight(200.dp)
        )
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeExTheme {
        Greeting4("Android")
    }
}