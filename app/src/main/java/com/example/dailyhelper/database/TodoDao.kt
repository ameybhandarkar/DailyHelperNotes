package com.example.dailyhelper.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * from to_do_dtl_table WHERE todo_id = :key")
    fun getTodoDetail(key: Long): TodoDao
}