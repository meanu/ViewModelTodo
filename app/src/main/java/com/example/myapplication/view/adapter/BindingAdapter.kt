package com.example.myapplication.view.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.TodoModel
import com.example.myapplication.viewmodel.TodoViewModel

@BindingAdapter(value = ["todolists", "viewmodel"])
fun setLists(view: RecyclerView, items: List<TodoModel>?, vm: TodoViewModel){
    view.adapter?.run{
        if (this is TodoAdapter) this.submitList(items)
    }

}