package com.example.taskmanager_4m.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanager_4m.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll():List<Task>

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)
}