package com.example.dailyhelper.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "todomaintable"
)
data class ToDoMainTable(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "todo_id")
    val todoParentId: Long,
    var todoTitle: String,
    var isSaved: Boolean,
    var isFavourite: Boolean
)