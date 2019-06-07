package com.example.kotilintodolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.kotilintodolist.adapters.TodoAdapter
import com.example.kotilintodolist.models.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val todos: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todos.add(Todo("First Task",false))

        rvTodos.layoutManager = LinearLayoutManager(this)
        val todoAdapter:TodoAdapter = TodoAdapter(todos)
        rvTodos.adapter = todoAdapter

        btnAdd.setOnClickListener{
            val newToDo= etNewTodo.text.toString()
            todos.add(Todo(newToDo,false))
            todoAdapter.notifyDataSetChanged()
        }
    }
}
