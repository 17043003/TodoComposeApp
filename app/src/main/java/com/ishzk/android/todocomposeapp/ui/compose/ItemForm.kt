package com.ishzk.android.todocomposeapp.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun AddItemForm(onClick: (String) -> Unit){
    val currentItemText = remember { mutableStateOf(TextFieldValue()) }
    Row {
        TextField(value = currentItemText.value, onValueChange = { currentItemText.value = it })
        Button(onClick = { onClick(currentItemText.value.text) }) {
            Text(text = "Add")
        }
    }
}
