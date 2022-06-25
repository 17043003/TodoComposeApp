package com.ishzk.android.todocomposeapp

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ishzk.android.todocomposeapp.repository.TodoDatabase

class RoomApplication: Application() {
    companion object {
        lateinit var database: RoomDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            "todo"
        ).build()
    }
}