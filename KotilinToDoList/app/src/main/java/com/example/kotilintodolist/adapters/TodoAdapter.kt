package com.example.kotilintodolist.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotilintodolist.R
import com.example.kotilintodolist.models.Todo
import kotlinx.android.synthetic.main.list_item_todo.view.*


class TodoAdapter(val todos:ArrayList<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TodoViewHolder {
        val li = p0?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView:View = li.inflate(R.layout.list_item_todo,p0,false)
        return TodoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return todos.size
        }

    override fun onBindViewHolder(p0: TodoViewHolder, p1: Int) {
        p0.tvTodoTask.text = todos[p1].task
    }

    class TodoViewHolder(val item: View) : RecyclerView.ViewHolder(item){
        val tvTodoTask:TextView = item.findViewById(R.id.tvTodoTask)
    }
}