package com.ishzk.android.todocomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ishzk.android.todocomposeapp.ui.theme.TodoComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TodoComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
                Column(
                    modifier = Modifier.padding(8.dp, 16.dp)
                ){
                    Row {
                        val currentItemText = remember { mutableStateOf(TextFieldValue()) }
                        TextField(value = currentItemText.value, onValueChange = { currentItemText.value = it })
                        addItemButton()
                    }
                    Row {
                        CheckList()
                    }
                }
            }
        }
    }
}

@Composable
fun CheckListItem(title: String = ""){
    Row{
        val checkedState = remember{ mutableStateOf(false) }
        Text(text = "$title", modifier = Modifier.align(Alignment.CenterVertically))
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = it
        })
    }
}

@Composable
fun CheckList(){
    LazyColumn{
        items(5){
            CheckListItem("$it")
        }
    }
}

@Composable
fun addItemButton(text: String = ""){
    Button(onClick = {}) {
        Text(text = "Add")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoComposeAppTheme {
        CheckList()
    }
}