package com.ctyeung.composeex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ctyeung.composeex.ui.theme.ComposeExTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    TopAppBar(title = {
                        Text("Exercise Compose")
                    })

                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(20.dp)) {

                        Spacer(Modifier.height(62.dp))

                        ClickableText(text = AnnotatedString("Click-A-Text"), onClick = onClickText)

                        Spacer(Modifier.height(32.dp))

                        Greeting2("Android")

                        Spacer(Modifier.height(32.dp))

                        var text by remember { mutableStateOf(TextFieldValue("Enter text here")) }
                        // BaseTextField is a composable that is used to take input. It is similar to EditText.
                        // onValueChange will be called when there is a change in content of text field.
                        TextField(
                            value = text,
                            modifier = Modifier.padding(16.dp).fillMaxWidth(),
                            onValueChange = {
                                text = it
                            }
                        )
                    }
                }
            }
        }
    }
    var onClickText: (Int) -> Unit = {}
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeExTheme {
        Greeting2("Android")
    }
}