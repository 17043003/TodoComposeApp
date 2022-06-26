package com.ishzk.android.todocomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ishzk.android.todocomposeapp.model.Todo
import com.ishzk.android.todocomposeapp.ui.compose.AddItemForm
import com.ishzk.android.todocomposeapp.ui.compose.CheckList
import com.ishzk.android.todocomposeapp.ui.theme.TodoComposeAppTheme
import com.ishzk.android.todocomposeapp.viewmodel.MainViewModel
import java.util.*

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadItems()

        setContent {
            TodoComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(viewModel = viewModel)
                }
            }
        }
    }

    @Composable
    fun MainScreen(viewModel: MainViewModel){
        Column(
            modifier = Modifier.padding(8.dp, 16.dp)
        ){
            AddItemForm{ text ->
                viewModel.add(
                    Todo(title = text, done = false, deadline = Date().time)
                )
            }
            CheckList(viewModel.todoLiveData, viewModel)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoComposeAppTheme {
        CheckList(listOf(Todo(1, "test1", false, Date().time)), MainViewModel())
    }
}