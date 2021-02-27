package com.meanu.mvvmtodolist.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.meanu.mvvmtodolist.R
import com.meanu.mvvmtodolist.view.ui.TodoActivity

class SplashActivity : AppCompatActivity() {

    val SPLASH_TIME_OUT: Long = 3000 //3초간 보여 주고 넘어 간다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)

        Handler().postDelayed({
            startActivity(Intent(this, TodoActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}