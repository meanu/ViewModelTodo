package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.TodoModel
import com.example.myapplication.view.adapter.TodoListAdapter
import com.example.myapplication.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.livedatarecyclerview.*
import kotlinx.android.synthetic.main.dialog_layout.view.*
import java.util.*
import kotlin.collections.ArrayList

class secondActivity : AppCompatActivity() {

    private lateinit var mTodoListAdapter: TodoListAdapter
    private lateinit var mTodoViewModel: TodoViewModel
    private val mTodoItems: ArrayList<TodoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.livedatarecyclerview)


        initRecyclerView()
        initAddButton()
        initViewModel()//observe 결합 코드는 oncreat 메소드내에 위치하는것이 바람직.
        btn_delt.setOnClickListener(View.OnClickListener {
            mTodoViewModel.delTodo()
        })
    }

    private fun initViewModel() {//ViewModel을 초기화 하는 방법은 일반 객체처럼 생성자로부터 호출하는 것이 아닌 Provider에 의해 초기화 되어야 한다
        mTodoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(TodoViewModel::class.java)
        mTodoViewModel.getTodoList().observe(this, androidx.lifecycle.Observer{
            mTodoListAdapter.setTodoItems(it)
        })
    }

    private fun initAddButton() {
        btn_add_todo.setOnClickListener {
            openAddTodoDialog()
        }
    }

    private fun openAddTodoDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_layout, null)
        val dialog = AlertDialog.Builder(this)
                .setTitle("ADD")
                .setView(dialogView)
                .setPositiveButton("확인",  {dialoginterface, i ->
                    val title =dialogView.et_todo_title.text.toString()
                    val description = dialogView.et_todo_desc.text.toString()
                    val createdDate = Date().time
                    val todoModel  = TodoModel(null, title, description, createdDate)
                    //전달되면 ROOM에의해 삽입되면서 할당된다.
                    mTodoViewModel.insertTodo(todoModel)
                })
                .setNegativeButton("취소", null)
                .create()
        dialog.show()
    }

    private fun initRecyclerView() {
        mTodoListAdapter = TodoListAdapter()
        rl_todo_list.run{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@secondActivity)
            adapter = mTodoListAdapter
        }
    }
}

