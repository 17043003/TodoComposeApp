package com.ishzk.android.todocomposeapp.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ishzk.android.todocomposeapp.model.Todo

@Composable
fun CheckListItem(title: String = "", done: Boolean = false){
    Row{
        val checkedState = remember{ mutableStateOf(done) }
        Text(text = "$title", modifier = Modifier.align(Alignment.CenterVertically))
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = it
        })
    }
}

@Composable
fun CheckList(items: List<Todo>){
    LazyColumn{
        items(items){
            key(it.id) {
                CheckListItem("${it.title}", it.done)
            }
        }
    }
}