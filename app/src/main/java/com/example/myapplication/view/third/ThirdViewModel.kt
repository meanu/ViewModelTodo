package com.example.myapplication.view.third

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myapplication.TodoDAO.TodoDAO
import com.example.myapplication.model.TodoModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class ThirdViewModel(private val dao: TodoDAO) : ViewModel() {
    val items: LiveData<PagedList<TodoModel>> = LivePagedListBuilder(dao.findAll(),  /* page size */ 10).build()

    fun delTodo(title: String) {
        Thread(Runnable {
            dao.deleteUser(title)
        }).start()
    }

    fun insertTodo(todoModel: TodoModel){
        Observable.just(todoModel)
            .subscribeOn(Schedulers.io())
            .subscribe({
                dao.insertTodo(it)
            },{

            }
            )
    }
}