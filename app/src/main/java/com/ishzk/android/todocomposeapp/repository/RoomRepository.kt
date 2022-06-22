package com.ishzk.android.todocomposeapp.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ishzk.android.todocomposeapp.model.Todo

@Dao
interface TodoDao{
    @Query("SELECT * FROM todo")
    fun selectAll(): Array<Todo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTodo(todo: Todo)
}