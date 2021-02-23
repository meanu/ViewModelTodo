//package com.example.myapplication.view.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.LiveData
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.model.TodoModel
//import kotlinx.android.synthetic.main.item_todo.view.*
//import java.text.SimpleDateFormat
//import java.util.*
//
//class TodoAdatper: ListAdapter<List<TodoModel>, TodoAdatper.TodoViewHolder>(TodoDiffCallback) {
//    private var todoItems: List<TodoModel> = listOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TodoViewHolder(
//        DataBindingUtil.inflate(LayoutInflater.from(parent.context), parent,false)
//    )
//
//    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    fun replaceItems(items: List<TodoModel>) {
//        submitList(items)
//    }
////    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) =
////    holder.bind(todoItems[position])
////
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TodoViewHolder(
////        ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
////    )
//
//    class TodoViewHolder(view: View, listener: TodoListAdapter.ItemClickListener?) :
//        RecyclerView.ViewHolder(view) {
//        val title = view.tv_todo_title
//        val description = view.tv_todo_description
//        val createdDate = view.tv_todo_created_date
//
//        init {
//            view.setOnClickListener {
//                listener?.onTodoItemClick(view, adapterPosition)
//            }
//            view.setOnLongClickListener {
//                listener?.onTodoItemLongClick(it, adapterPosition)
//                return@setOnLongClickListener true
//            }
//        }
//
//        fun bind(todoModel: TodoModel) {
//            title.text = todoModel.title
//            description.text = todoModel.description
//            createdDate.text = todoModel.createdDate.toDateString("yyyy.MM.dd HH:mm")
//        }
//
//        fun Long.toDateString(foramt: String): String {
//            val simpleDateFormat = SimpleDateFormat(foramt)
//            return simpleDateFormat.format((Date(this)))
//        }
//
//    }
//    object TodoDiffCallback : DiffUtil.ItemCallback<LiveData<TodoModel>>() {
//        override fun areContentsTheSame(oldItem: LiveData<TodoModel>, newItem: LiveData<TodoModel>): Boolean {
//            return oldItem.value?.id == newItem.value?.id
//        }
//
//        override fun areItemsTheSame(oldItem: LiveData<TodoModel>, newItem: LiveData<TodoModel>): Boolean {
//            return oldItem.value == newItem.value
//        }
//    }
//}