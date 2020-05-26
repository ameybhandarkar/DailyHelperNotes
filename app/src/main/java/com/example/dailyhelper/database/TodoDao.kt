package com.example.dailyhelper.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * from tododtltable WHERE toDoParentId = :key")
    fun getTodoDetail(key: Long): LiveData<MutableList<ToDoDtlTable>>
}