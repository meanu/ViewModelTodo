package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.roomModule
import com.example.myapplication.di.viewModelModule
import org.koin.android.ext.android.startKoin

@Suppress("Unused")
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            roomModule,
            viewModelModule
        ))
    }

}