package com.example.myapplication.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import androidx.annotation.RequiresApi
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

    var scene1: Scene? = null
    var scene2: Scene? = null
    var transitionMgr: Transition? = null
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transitionMgr = TransitionInflater.from(this)
            .inflateTransition(R.transition.transition)

//        scene1 = Scene.getSceneForLayout(rootContainer,
//            R.layout.scene1_layout, this)

//        scene2 = Scene.getSceneForLayout(rootContainer,
//            R.layout.scene2_layout, this)

        scene1?.enter()

        val tm = TransitionManager()
//        tm.setTransition(R.anim.slide_in_right, R.anim.slide_out_right,null)
        button1.setOnClickListener {
            val nextIntent = Intent(this, secondActivity::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(nextIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
//            overridePendingTransition(R.anim.slide_in_right,R.anim.hold)
            // TODO: 2021-01-05 transition 만들기 
            }

        button2.setOnClickListener {
            val nextIntent = Intent(this, thirdActivity::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(nextIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
        }
    }
}