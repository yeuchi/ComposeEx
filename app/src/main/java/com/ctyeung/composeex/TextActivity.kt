package com.ctyeung.composeex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                        Text("Exercise Text Elements")
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

                        var snackbarVisibleState = remember { mutableStateOf(false) }

                        Spacer(Modifier.height(62.dp))

                        var onClickText: (Int) -> Unit = {
                            snackbarVisibleState.value = !snackbarVisibleState.value
                        }

                        ClickableText(text = AnnotatedString("Click-A-Text"), onClick = onClickText)

                        Spacer(Modifier.height(32.dp))

                        Greeting2("Android")

                        Spacer(Modifier.height(32.dp))

                        var text by remember { mutableStateOf(TextFieldValue("Enter text here")) }
                        // BaseTextField is a composable that is used to take input. It is similar to EditText.
                        // onValueChange will be called when there is a change in content of text field.
                        TextField(
                            value = text,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            onValueChange = {
                                text = it
                            }
                        )

                        if (snackbarVisibleState.value) {
                            Snackbar(

                                action = {
                                    Button(onClick = {}) {
                                        Text("MyAction")
                                    }
                                },
                                modifier = Modifier.padding(8.dp)
                            ) { Text(text = "This is a snackbar!") }
                        }
                    }
                }
            }
        }
    }

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