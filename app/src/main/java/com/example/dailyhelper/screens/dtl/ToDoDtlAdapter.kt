package com.example.dailyhelper.screens.dtl

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyhelper.database.ToDoDtlModel
import com.example.dailyhelper.databinding.ItemWithCheckBoxBinding

class ToDoDtlAdapter: ListAdapter<ToDoDtlModel, ToDoDtlAdapter.ViewHolder>(ToDoDtlDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ItemWithCheckBoxBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: ToDoDtlModel) {
            binding.todoModel = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemWithCheckBoxBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class ToDoDtlDiffCallback : DiffUtil.ItemCallback<ToDoDtlModel>() {

    override fun areItemsTheSame(oldItem: ToDoDtlModel, newItem: ToDoDtlModel): Boolean {
        return oldItem.todoId == newItem.todoId
    }


    override fun areContentsTheSame(oldItem: ToDoDtlModel, newItem: ToDoDtlModel): Boolean {
        return oldItem == newItem
    }


}