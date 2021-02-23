package com.meanu.mvvmtodolist

import android.app.Application
import com.meanu.mvvmtodolist.di.roomModule
import com.meanu.mvvmtodolist.di.viewModelModule
import org.koin.android.ext.android.startKoin

@Suppress("Unused")
class MVVMtodo : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            roomModule,
            viewModelModule
        ))
    }

}