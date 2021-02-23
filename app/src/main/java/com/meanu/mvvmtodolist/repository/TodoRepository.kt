package com.meanu.mvvmtodolist.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.meanu.mvvmtodolist.TodoDAO.TodoDAO
import com.meanu.mvvmtodolist.TodoDAO.TodoDatabase
import com.meanu.mvvmtodolist.model.TodoModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class TodoRepository(application: Application) {
    private var mTodoDatabase: TodoDatabase
    private var mTodoDAO: TodoDAO
    private var mTodoItems: LiveData<List<TodoModel>>

    init {//init 은 전역변수 정하는듯함.
        mTodoDatabase = TodoDatabase.getInstance(application)
        mTodoDAO = mTodoDatabase.getTodoDao()
        mTodoItems = mTodoDAO.getTodoList()

    }
    fun getTodoList(): LiveData<List<TodoModel>>{
        return mTodoItems
    }

    fun delTodo(title: String) {
        Thread(Runnable {
        mTodoDAO.deleteUser(title)
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
