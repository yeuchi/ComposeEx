package com.ctyeung.composeex

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctyeung.composeex.ui.theme.ComposeExTheme

/*
 * Question
 * 1. how to add compose to an existing project ?
 * 2. constraint layout
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExTheme {

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    TopAppBar(title = {
                        Text("Exercise Compose")
                    })

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(Modifier.height(62.dp))

                        Button(
                            onClick = onClickText,
                            enabled = true,
                            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                            shape = MaterialTheme.shapes.medium,
                        )
                        {
                            Text(text = "Text", color = Color.White)
                        }

                        Spacer(Modifier.height(32.dp))

                        Button(
                            onClick = onClickButton,
                            enabled = true,

                            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                            shape = MaterialTheme.shapes.medium,
                        )
                        {
                            Text(text = "Buttons", color = Color.White)
                        }

                        Spacer(Modifier.height(32.dp))

                        Button(
                            onClick = onClickAnimate,
                            enabled = true,

                            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                            shape = MaterialTheme.shapes.medium,
                        )
                        {
                            Text(text = "Animate", color = Color.White)
                        }
                    }
                }
            }
        }
    }

    var onClickText: () -> Unit = {
        startActivity(
            Intent(this, TextActivity::class.java)
        )
    }

    var onClickButton: () -> Unit = {
        startActivity(
            Intent(this, ButtonActivity::class.java)
        )
    }

    var onClickAnimate: () -> Unit = {
        startActivity(
            Intent(this, AnimateActivity::class.java)
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExTheme {
        Greeting("Android")
    }
}