package com.ishzk.android.todocomposeapp.repository

import androidx.room.*
import com.ishzk.android.todocomposeapp.model.Todo

@Dao
interface TodoDao{
    @Query("SELECT * FROM todo")
    fun selectAll(): Array<Todo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTodo(todo: Todo)

    @Query("DELETE FROM todo WHERE id = :id")
    fun deleteTodo(id: Int)
}

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase: RoomDatabase(){
    abstract fun todoDao(): TodoDao
}