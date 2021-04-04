package com.ctyeung.composeex

import android.media.Image
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BaseTextField
import androidx.compose.foundation.ClickableText
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import org.w3c.dom.Text as Text
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
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

                    // Edit Text
                    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
                        var text by remember { mutableStateOf(TextFieldValue("Enter text here")) }
                        // BaseTextField is a composable that is used to take input. It is similar to EditText.
                        // onValueChange will be called when there is a change in content of text field.
                        BaseTextField(
                            value = text,
                            modifier = Modifier.padding(16.dp).fillMaxWidth(),
                            onValueChange = {
                                text = it
                            }
                        )
                    }
                    
                //                    TextField(
//                        value = "abc",
//                        onValueChange = { },
//                        singleLine = true
//                    )

//                    Image(
//                        painter=painterResource(R.drawable.ic_header_background),
//                                contentDescription=null
//                    )
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text (text = "Hello $name!")
    }

}