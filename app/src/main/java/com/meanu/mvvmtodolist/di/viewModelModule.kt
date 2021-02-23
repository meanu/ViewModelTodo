package com.meanu.mvvmtodolist.di

import com.meanu.mvvmtodolist.view.third.ThirdViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { ThirdViewModel(get()) }
}