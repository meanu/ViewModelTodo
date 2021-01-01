package com.example.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.TodoModel
import com.example.myapplication.view.adapter.TodoListAdapter
import com.example.myapplication.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.livedatarecyclerview.*
import kotlinx.android.synthetic.main.dialog_layout.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val nextIntent = Intent(this, secondActivity::class.java)
            startActivity(nextIntent)   }
        button2.setOnClickListener {
            val nextIntent = Intent(this, thirdActivity::class.java)
            startActivity(nextIntent)   }
    }
}