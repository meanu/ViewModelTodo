package com.example.myapplication.di

import com.example.myapplication.view.third.ThirdViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { ThirdViewModel(get()) }
}