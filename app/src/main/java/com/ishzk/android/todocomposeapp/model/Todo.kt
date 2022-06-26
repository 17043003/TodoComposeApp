package com.ishzk.android.todocomposeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val done: Boolean = false,
    val deadline: Long,
)
