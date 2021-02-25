package com.meanu.mvvmtodolist.di

import com.meanu.mvvmtodolist.view.ui.TodoViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { TodoViewModel(get()) }
}