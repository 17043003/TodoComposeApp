package com.ishzk.android.todocomposeapp.viewmodel

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ishzk.android.todocomposeapp.RoomApplication
import com.ishzk.android.todocomposeapp.model.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    val todoLiveData: SnapshotStateList<Todo> by lazy { SnapshotStateList() }
    fun add(item: Todo){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default){
                RoomApplication.database.todoDao().insertTodo(item)
                loadItems()
            }
        }
    }

    fun loadItems(){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default){
                todoLiveData.clear()
                val items = RoomApplication.database.todoDao().selectAll()
                todoLiveData.addAll(items)
            }
        }
    }

    fun deleteItem(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default){
                RoomApplication.database.todoDao().deleteTodo(id)
                loadItems()
            }
        }
    }
}