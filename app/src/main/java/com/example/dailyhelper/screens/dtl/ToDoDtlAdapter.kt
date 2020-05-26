package com.example.dailyhelper.screens.dtl

import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyhelper.database.ToDoDtlTable
import com.example.dailyhelper.databinding.ItemWithCheckBoxBinding
import android.view.inputmethod.EditorInfo

import android.widget.TextView

import android.widget.TextView.OnEditorActionListener




class ToDoDtlAdapter: ListAdapter<ToDoDtlTable, ToDoDtlAdapter.ViewHolder>(ToDoDtlDiffCallback()) {
    var data =  mutableListOf<ToDoDtlTable>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size
    override fun getItem(position: Int): ToDoDtlTable {
        return data[position]
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent,data)
    }

    fun addEmptyItem(){
        val emptyTodoObj = ToDoDtlTable()
        data.add(emptyTodoObj)
    }

    class ViewHolder private constructor(val binding: ItemWithCheckBoxBinding, var listData: MutableList<ToDoDtlTable>) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: ToDoDtlTable) {
            binding.todoModel = item
            binding.executePendingBindings()

            binding.etTodo.setOnEditorActionListener { v, actionId, event ->
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    addEmptyItem()
                    true
                } else {
                    false
                }
            }
        }

        fun addEmptyItem(){
            val emptyTodoObj = ToDoDtlTable()
            listData.add(emptyTodoObj)
        }

        companion object {
            fun from(parent: ViewGroup, listData: MutableList<ToDoDtlTable>): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemWithCheckBoxBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, listData)
            }
        }
    }
}


class ToDoDtlDiffCallback : DiffUtil.ItemCallback<ToDoDtlTable>() {

    override fun areItemsTheSame(oldItem: ToDoDtlTable, newItem: ToDoDtlTable): Boolean {
        return oldItem.todoChildId == newItem.todoChildId
    }


    override fun areContentsTheSame(oldItem: ToDoDtlTable, newItem: ToDoDtlTable): Boolean {
        return oldItem == newItem
    }


}