package com.example.myapplication.view.adapter

import androidx.paging.PagedListAdapter
import com.example.myapplication.model.TodoModel
import com.example.myapplication.viewmodel.TodoViewModel

class TodoAdapter (val vm: TodoViewModel) :
        PagedListAdapter<TodoModel,