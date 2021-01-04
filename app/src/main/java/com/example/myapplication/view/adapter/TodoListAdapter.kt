package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.TodoModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //TodoListAdapter 생성자에서 리스트를 받았엇는데
    private var todoItems: List<TodoModel> = listOf()
    var listener: OnTodoItemClickListener? = null

    interface OnTodoItemClickListener {
        fun onTodoItemClick(position: Int)
        fun onTodoItemLongClick(position: Int)
    }

    fun setTodoItems(todoItems: List<TodoModel>){

        // DiffUtil은 시간복잡도가 높다. 그렇기 때문에 별도의 쓰레드에서 작업하는 것이 더 좋은 방법이 될 수 있다. Rx를 활용하여 코드를 수정 해 보자.
        Observable.just(todoItems)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map { DiffUtil.calculateDiff(TodoListDIffCallback(this.todoItems,todoItems)) }
                .subscribe({
                    val diffCallback = TodoListDIffCallback(this.todoItems, todoItems)
                    val diffResult = DiffUtil.calculateDiff(diffCallback)
                    this.todoItems = todoItems
                    diffResult.dispatchUpdatesTo(this@TodoListAdapter)
                })
        // TODO: 2021-01-04 adapter에 notify가 안됨
        //2번째적었던것
//        val diffCallback = TodoListDIffCallback(this.todoItems, todoItems)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
//        this.todoItems = todoItems
//        diffResult.dispatchUpdatesTo(this@TodoListAdapter)
       
//        1번째 적었던것
//        notifyDataSetChanged()
//
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        val viewHolder = TodoViewHolder(view, listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val todoModel = todoItems[position]
        val todoViewHolder = holder as TodoViewHolder
        todoViewHolder.bind(todoModel)
    }

    class TodoViewHolder(view: View, listener: OnTodoItemClickListener?): RecyclerView.ViewHolder(view) {
        val title = view.tv_todo_title
        val description = view.tv_todo_description
        val createdDate = view.tv_todo_created_date

        init {
            view.setOnClickListener {
                listener?.onTodoItemClick(adapterPosition)
            }
            view.setOnLongClickListener {
                listener?.onTodoItemLongClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }

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