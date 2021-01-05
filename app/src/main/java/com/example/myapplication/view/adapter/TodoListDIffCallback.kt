package com.example.myapplication.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.model.TodoModel

class TodoListDIffCallback(val oldTodoList: List<TodoModel>, val newTodoList: List<TodoModel>): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTodoList[oldItemPosition].id == newTodoList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldTodoList.size
    }

    override fun getNewListSize(): Int = newTodoList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newTodoList[newItemPosition].equals(oldTodoList[oldItemPosition])
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }//

}