package com.ctyeung.composeex


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.IconButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ctyeung.composeex.ui.theme.ComposeExTheme

class ButtonActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    TopAppBar(title = {
                        Text("Exercise Buttons")
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

                    val radioOptions = listOf("rdo1", "rdo2", "rdo3")
                    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Button(
                            onClick = onClickButton,
                            enabled = true,

                            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                            shape = MaterialTheme.shapes.medium,
                        )
                        {
                            Text(text = "Basic Button", color = Color.White)
                        }

                        var onClickTextButton: (Int) -> Unit = {

                        }

                        Spacer(Modifier.height(32.dp))

                        ClickableText(
                            text = AnnotatedString("Text Button"),
                            onClick = onClickTextButton
                        )

                        Spacer(Modifier.height(32.dp))

                        radioOptions.forEach { text ->
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = (text == selectedOption),
                                        onClick = { onOptionSelected(text) }
                                    )
                                    .padding(horizontal = 16.dp)
                            ) {
                                RadioButton(
                                    selected = (text == selectedOption),
                                    modifier = Modifier.padding(all = Dp(value = 8F)),
                                    onClick = {
                                        onOptionSelected(text)
                                    }
                                )
                                Text(
                                    text = text,
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                            }
                        }
                        CheckBoxTest()
                    }
                }
            }
        }
    }

    var onClickButton: () -> Unit = {

    }
}

@Composable
fun CheckBoxTest() {
    val checkedState = remember { mutableStateOf(true) }
    Checkbox(checked = checkedState.value, onCheckedChange = { checked ->
        checkedState.value = checked
    })
    Text(text="Checkbox")
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeExTheme {
        Greeting3("Android")
    }
}