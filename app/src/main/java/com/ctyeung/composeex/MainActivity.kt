package com.ctyeung.composeex

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.w3c.dom.Text as Text
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent {
            MaterialTheme {
                    TopAppBar(title = {
                        Text("Hello World")
                    })

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    ClickableText(text = AnnotatedString.Builder("Hello").toAnnotatedString(), onClick = { Toast.makeText(this@MainActivity.applicationContext, "You clicked me", Toast.LENGTH_LONG).show() })
                    val txt = Text("Hello World!", style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 30.sp, color = Color.Green))
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text (text = "Hello $name!")
    }
}