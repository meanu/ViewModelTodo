package com.example.myapplication.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.myapplication.TodoDAO.TodoDAO
import com.example.myapplication.TodoDAO.TodoDatabase
import com.example.myapplication.model.TodoModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class TodoRepository(application: Application) {
    private var mTodoDatabase: TodoDatabase
    private var mTodoDAO: TodoDAO
    private var mTodoItems: LiveData<List<TodoModel>>

    init {//init 은 전역변수 정하는듯함.
        mTodoDatabase = TodoDatabase.getInstance(application)
        mTodoDAO = mTodoDatabase.todoDao()
        mTodoItems = mTodoDAO.getTodoList()

    }
    fun getTodoList(): LiveData<List<TodoModel>>{
        return mTodoItems
    }

    fun delTodo(){
        Thread(Runnable {
        mTodoDAO.deleteUser()
        }).start()

    }

    fun insertTodo(todoModel: TodoModel){
        Observable.just(todoModel)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mTodoDAO.insertTodo(todoModel)
                },{

                }
                )
    }
}
