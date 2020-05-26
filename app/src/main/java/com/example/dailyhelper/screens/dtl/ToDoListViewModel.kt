package com.example.dailyhelper.screens.dtl

import android.app.Application
import android.text.format.DateUtils
import androidx.lifecycle.ViewModel
import com.example.dailyhelper.database.TodoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ToDoListViewModel(
    private val dataSource: TodoDao,
    private val application: Application
) : ViewModel() {
    val database = dataSource
    val todoMainId = System.currentTimeMillis()
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val todoDtlList = database.getTodoDetail(todoMainId);
}
