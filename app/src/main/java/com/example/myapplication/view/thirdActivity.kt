package com.example.myapplication.view

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.view.adapter.ThirdAdapter
import com.example.myapplication.view.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.livedatarecyclerview.*
import kotlinx.android.synthetic.main.third_layout.*

class thirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            with(window) {
                requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
                // set an slide transition
                enterTransition = Slide(Gravity.TOP)
                exitTransition = Slide(Gravity.BOTTOM)
            }
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)

        rl_list.adapter = ThirdAdapter()
        rl_list.layoutManager = LinearLayoutManager(this)
        Toast.makeText(this, "ag", Toast.LENGTH_SHORT).show()

    }
}
