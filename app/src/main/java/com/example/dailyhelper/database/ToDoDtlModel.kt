package com.example.dailyhelper.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "to_do_dtl_table")
data class ToDoDtlModel(val id: Long, val todoDesc: String) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "todo_id")
    val todoId: Long = id

    @ColumnInfo(name = "todo_desc")
    var todoDescription: String = todoDesc

    @ColumnInfo(name = "is_checked")
    var isChecked: Boolean = false
}