package com.meanu.mvvmtodolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.meanu.mvvmtodolist.model.TodoModel
import com.meanu.mvvmtodolist.repository.TodoRepository

class TodoViewModel(application: Application): AndroidViewModel(application){
    private val mTodoRepository: TodoRepository
    private var mTodoItems: LiveData<List<TodoModel>>


    init {
        mTodoRepository = TodoRepository(application)
        mTodoItems = mTodoRepository.getTodoList()
    }

    fun insertTodo(todoModel: TodoModel){
        mTodoRepository.insertTodo(todoModel)
    }

    fun getTodoList(): LiveData<List<TodoModel>> {
        return mTodoItems
    }

    fun delTodo(title:String){
        mTodoRepository.delTodo(title)
    }

}

//resposit 활용해서 코드가 간단.
//respository에서 데이터 가져와서 viewmodel이 간단해진다.
//주의: viewModel에서 context를 가지면 메모리의 누수. 그래서 application으로 넘겨서 받는다.