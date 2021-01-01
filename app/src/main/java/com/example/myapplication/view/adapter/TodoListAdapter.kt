package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.TodoModel
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TodoListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //TodoListAdapter 생성자에서 리스트를 받았엇는데
    private var todoItems: List<TodoModel> = listOf()
    fun setTodoItems(todoItems: List<TodoModel>){
        this.todoItems = todoItems
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        val viewHolder = TodoViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val todoModel = todoItems[position]

        val todoViewHolder = holder as TodoViewHolder
        todoViewHolder.bind(todoModel)
    }


    class TodoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.tv_todo_title
        val description = view.tv_todo_description
        val createdDate = view.tv_todo_created_date

        fun bind(todoModel: TodoModel){
            title.text = todoModel.title
            description.text = todoModel.description
            createdDate.text = todoModel.createdDate.toDateString("yyyy.MM.dd HH:mm")
        }

        fun Long.toDateString(foramt: String): String {
            val simpleDateFormat = SimpleDateFormat(foramt)
            return simpleDateFormat.format((Date(this)))
        }

    }
}