package com.meanu.mvvmtodolist.view.third

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.meanu.mvvmtodolist.R
import com.meanu.mvvmtodolist.databinding.ItemTodoBinding
import com.meanu.mvvmtodolist.model.TodoModel

class TodoAdapter (val vm: ThirdViewModel) :
        PagedListAdapter<TodoModel, TodoAdapter.TodoViewHolder>(DIFF_CALLBACK) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
                return TodoViewHolder(
                        LayoutInflater.from(parent.context).inflate(
                                R.layout.item_todo,
                                parent,
                                false
                        )
                )
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
                getItem(position)?.run {
                        holder.binding.todoitems = this
                        holder.binding.vm = vm
                }
        }
        class TodoViewHolder(view : View) : BindingViewHolder<ItemTodoBinding>(view)

        companion object {
                private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TodoModel>() {
                        override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel) = oldItem.id == newItem.id
                        override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel) = oldItem == newItem
                }
        }


}