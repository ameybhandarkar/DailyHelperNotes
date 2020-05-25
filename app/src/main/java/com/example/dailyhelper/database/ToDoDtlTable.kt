package com.example.dailyhelper.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = arrayOf(
        ForeignKey(
            entity = ToDoMainTable::class,
            parentColumns = arrayOf("todoParentId"),
            childColumns = arrayOf("toDoParentId"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class ToDoDtlTable(
    @PrimaryKey(autoGenerate = true)
    val todoChildId: Long,
    val toDoParentId: Long,
    var todoDescription: String,
    var isChecked: Boolean = false
)