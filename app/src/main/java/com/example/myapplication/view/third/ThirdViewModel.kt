package com.example.myapplication.view.third

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myapplication.TodoDAO.TodoDAO
import com.example.myapplication.core.BaseViewModel
import com.example.myapplication.model.TodoModel

class ThirdViewModel(private val dao: TodoDAO) : BaseViewModel() {
    val items: LiveData<PagedList<TodoModel>> = LivePagedListBuilder(dao.findAll(),  /* page size */ 1).build()

//    fun delete(todoModel: TodoModel) = ioThread { dao.delete(bookmark) }
}