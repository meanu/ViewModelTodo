package com.meanu.mvvmtodolist.view.ui

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.meanu.mvvmtodolist.model.TodoModel

@BindingAdapter(value = ["todolists", "viewModel"])
fun setLists(view: RecyclerView, items: PagedList<TodoModel>?, vm: TodoViewModel) {
    view.adapter?.run {
        if (this is TodoAdapter) this.submitList(items)
    } ?: run {
        TodoAdapter(vm).apply {
            view.adapter = this
            this.submitList(items)
        }
    }
}