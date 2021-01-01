package com.example.myapplication.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.view.adapter.ThirdAdapter
import com.example.myapplication.view.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.livedatarecyclerview.*
import kotlinx.android.synthetic.main.third_layout.*

class thirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)

        rl_list.adapter = ThirdAdapter()
        rl_list.layoutManager = LinearLayoutManager(this)


    }
}
