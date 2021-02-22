package com.example.myapplication.view.third

import android.os.Build
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R
import com.example.myapplication.databinding.ThirdLayoutBinding
import com.example.myapplication.model.TodoModel
import kotlinx.android.synthetic.main.dialog_layout.view.*
import kotlinx.android.synthetic.main.third_layout.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ThirdActivity : BindingActivity<ThirdLayoutBinding>() {
    @LayoutRes
    override fun getLayoutResId() = R.layout.third_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)
        btn_add_todo.setOnClickListener{
            openAddTodoDialog()
        }
    }

    fun openAddTodoDialog() {
            val dialogView = layoutInflater.inflate(R.layout.dialog_layout, null)
            val dialog = AlertDialog.Builder(this)
                .setTitle("Add TODOLIST")
                .setView(dialogView)
                .setPositiveButton("CONFIRM",  {dialoginterface, i ->

                    val title =dialogView.et_todo_title.text.toString()
                    val description = dialogView.et_todo_desc.text.toString()
                    val currentDateTime = Calendar.getInstance().time
                    val createdDate = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime)
                    val todoModel = TodoModel(null, title, description, createdDate)

                    //전달되면 ROOM에의해 삽입되면서 할당된다.
                    val model : ThirdViewModel = getViewModel()
                    model.insertTodo(todoModel)
                })
                .setNegativeButton("CANCLE", null)
                .create()
            dialog.show()
    }
}