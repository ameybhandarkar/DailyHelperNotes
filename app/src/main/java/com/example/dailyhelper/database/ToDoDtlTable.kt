package com.example.dailyhelper.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = ToDoMainTable::class,
        parentColumns = arrayOf("todo_id"),
        childColumns = arrayOf("toDoParentId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class ToDoDtlTable(
    @PrimaryKey(autoGenerate = true)
    val todoChildId: Long,
    @ColumnInfo(index = true,name = "toDoParentId")
    val toDoParentId: Long,
    var todoDescription: String,
    var isChecked: Boolean = false
){
    constructor() : this(0L,0L,"")
}