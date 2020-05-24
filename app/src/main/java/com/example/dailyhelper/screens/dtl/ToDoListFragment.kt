package com.example.dailyhelper.screens.dtl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dailyhelper.BaseFragment
import com.example.dailyhelper.R
import com.example.dailyhelper.databinding.TodolistFragmentBinding


class ToDoListFragment : BaseFragment() {

    companion object {
        fun newInstance() = ToDoListFragment()
    }

    private lateinit var viewModel: ToDoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TodolistFragmentBinding>(
            inflater,
            R.layout.todolist_fragment, container, false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModelFactory = (ToDoViewModelFactory())
        viewModel = ViewModelProvider(
            viewModelStore,
            viewModelFactory
        )
            .get(ToDoListViewModel::class.java)
    }

}
