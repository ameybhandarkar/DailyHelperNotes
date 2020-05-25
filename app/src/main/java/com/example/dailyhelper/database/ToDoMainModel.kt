package com.example.dailyhelper.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "to_do_main_table")
data class ToDoMainModel(val id: Long, var title: String) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "todo_id")
    val todoId: Long = id

    @ColumnInfo(name = "todo_title")
    var todoTitle: String = title

    @ColumnInfo(name = "is_saved")
    var isSaved: Boolean = false
}