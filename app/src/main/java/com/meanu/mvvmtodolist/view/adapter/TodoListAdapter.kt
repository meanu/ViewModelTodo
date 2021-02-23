package com.meanu.mvvmtodolist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.meanu.mvvmtodolist.R
import com.meanu.mvvmtodolist.model.TodoModel
import kotlinx.android.synthetic.main.item_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //TodoListAdapter 생성자에서 리스트를 받았엇는데
    private var todoItems: List<TodoModel> = listOf()
    private val asyncListDIffer = AsyncListDiffer(this, DiffUtilCallBack())

    interface ItemClickListener {
        fun onTodoItemClick(view: View,position: Int)
        fun onTodoItemLongClick(view: View,position: Int)
    }

    private lateinit var listener: ItemClickListener


    fun setItemClickListener(listener: ItemClickListener) {
        this.listener = listener
    }

    fun setTodoItems(todoItems: List<TodoModel>){
        // DiffUtil은 시간복잡도가 높다. 그렇기 때문에 별도의 쓰레드에서 작업하는 것이 더 좋은 방법이 될 수 있다. Rx를 활용하여 코드를 수정 해 보자.
//        Observable.just(todoItems)
//        .subscribeOn(AndroidSchedulers.mainThread())
//        .observeOn(Schedulers.io())
//        .map { DiffUtil.calculateDiff(TodoListDIffCallback(this.todoItems, todoItems)) }
//        .subscribe({
//            this.todoItems = todoItems
//            it.dispatchUpdatesTo(this) },     // TODO notify가 안되요
//        { })
        this.todoItems = todoItems
        notifyDataSetChanged()
//        asyncListDIffer.submitList(todoItems)
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
        holder.itemView.setOnClickListener {
            listener.onTodoItemClick(it,position)
        }
    }

    class TodoViewHolder(view: View, listener: ItemClickListener?): RecyclerView.ViewHolder(view) {
        val title = view.tv_todo_title
        val description = view.tv_todo_description
        val createdDate = view.tv_todo_created_date

        init {
            view.setOnClickListener {
                listener?.onTodoItemClick(view,adapterPosition)
            }
            view.setOnLongClickListener {
                listener?.onTodoItemLongClick(it,adapterPosition)
                return@setOnLongClickListener true
            }
        }

        fun bind(todoModel: TodoModel){
//            title.text = todoModel.title
//            description.text = todoModel.description
//            createdDate.text = todoModel.createdDate.toDateString("yyyy.MM.dd HH:mm")
        }

        fun Long.toDateString(foramt: String): String {
            val simpleDateFormat = SimpleDateFormat(foramt)
            return simpleDateFormat.format((Date(this)))
        }

    }

}