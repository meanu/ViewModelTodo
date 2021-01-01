package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.MainData
import com.example.myapplication.model.TodoModel
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class ThirdAdapter: RecyclerView.Adapter<ThirdAdapter.ThirdViewHolder>() {

    var items: MutableList<MainData> = mutableListOf(MainData("dd", "dd", "dd", "dd"),
        MainData("dd", "dd", "dd", "dd"),MainData("dd", "dd", "dd", "dd"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        val viewHolder = ThirdViewHolder(view)

        return viewHolder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ThirdViewHolder, position: Int) {
        val item = items[position]

        val thirdViewHolder = holder as ThirdAdapter.ThirdViewHolder
        thirdViewHolder.bind(item)
    }

    inner class ThirdViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title = view.tv_todo_title
        val description = view.tv_todo_description
        val createdDate = view.tv_todo_created_date

        fun bind(todoModel: MainData){
            title.text = todoModel.title
            description.text = todoModel.description
            createdDate.text = todoModel.createdDate
        }


    }
}