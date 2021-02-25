package com.meanu.mvvmtodolist.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.meanu.mvvmtodolist.TodoDAO.TodoDAO
import com.meanu.mvvmtodolist.model.TodoModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class TodoViewModel(private val dao: TodoDAO) : ViewModel() {
    val items: LiveData<PagedList<TodoModel>> = LivePagedListBuilder(dao.findAll(),  /* page size */ 10).build()

    fun delTodo(title: String) {
        Observable.just(title)
            .subscribeOn(Schedulers.io())
            .subscribe({
                dao.deleteUser(title)
            }
        )
    }

    fun insertTodo(todoModel: TodoModel){
        Observable.just(todoModel)
            .subscribeOn(Schedulers.io())
            .subscribe({
                dao.insertTodo(it)
            }
        )
    }
}