package com.example.myapplication.view.third

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.TodoModel
import com.example.myapplication.viewmodel.TodoViewModel

@BindingAdapter(value = ["todolists", "viewModel"])
fun setLists(view: RecyclerView, items: PagedList<TodoModel>?, vm: ThirdViewModel) {
    view.adapter?.run {
        if (this is TodoAdapter) this.submitList(items)
    } ?: run {
        TodoAdapter(vm).apply {
            view.adapter = this
            this.submitList(items)
        }
    }
}