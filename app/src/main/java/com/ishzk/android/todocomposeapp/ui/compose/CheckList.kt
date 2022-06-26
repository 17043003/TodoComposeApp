package com.ishzk.android.todocomposeapp.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ishzk.android.todocomposeapp.model.Todo
import com.ishzk.android.todocomposeapp.viewmodel.MainViewModel

@Composable
fun CheckListItem(item: Todo, onUpdate: (Todo)-> Unit, onDelete: (Int) -> Unit){
    val menuState = remember { mutableStateOf(false) }
    Row{
        val checkedState = remember{ mutableStateOf(item.done) }
        Text(text = "${item.title}", modifier = Modifier.align(Alignment.CenterVertically))
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = it
            val newItem = item.copy(done = checkedState.value)
            onUpdate(newItem)
        })
        IconButton(onClick = { menuState.value = !menuState.value }) {
            Icon(Icons.Filled.MoreVert, "menu")
        }
        DropdownMenu(expanded = menuState.value, onDismissRequest = { menuState.value = false }) {
            DropdownMenuItem(onClick = {
                menuState.value = false
                item.id?.let { onDelete(it) }
            }) {
                Text(text = "Delete")
            }
        }
    }
}

@Composable
fun CheckList(items: List<Todo>, viewModel: MainViewModel){
    LazyColumn{
        items(items){ item ->
            if(item.id != null) {
                key(item.id) {
                    CheckListItem(item, {
                        viewModel.updateItem(it)
                    }) { id ->
                        viewModel.deleteItem(id)
                    }
                }
            }
        }
    }
}