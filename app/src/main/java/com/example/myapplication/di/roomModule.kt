package com.example.myapplication.di

import com.example.myapplication.TodoDAO.TodoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomModule = module {
    single { TodoDatabase.getInstance(androidApplication()) }
    single(createOnStart = false) { get<TodoDatabase>().getTodoDao() }
}