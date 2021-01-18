package com.example.myapplication.view.adapter

import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.model.TodoModel

class DiffUtilCallBack : DiffUtil.ItemCallback<LiveData<TodoModel>>() {
    override fun areItemsTheSame(oldItem: LiveData<TodoModel>, newItem: LiveData<TodoModel>) =
        oldItem.value?.id == newItem.value?.id

    override fun areContentsTheSame(oldItem: LiveData<TodoModel>, newItem: LiveData<TodoModel>) =
        oldItem.value == newItem.value
}