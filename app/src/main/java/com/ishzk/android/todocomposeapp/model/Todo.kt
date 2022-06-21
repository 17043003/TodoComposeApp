package com.ishzk.android.todocomposeapp.model

data class Todo(
    val title: String,
    val completed: Boolean = false,
    val deadline: Long,
)
