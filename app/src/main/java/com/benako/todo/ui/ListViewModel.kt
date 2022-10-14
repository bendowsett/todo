package com.benako.todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.benako.todo.data.Todos
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ListViewModel: ViewModel() {

    private val _exampleTodos: MutableList<LiveData<Todos>> = mutableListOf()
            val exampleTodos get() = _exampleTodos



    fun addToDo(todo: String){
        _exampleTodos.add(Todos(todo))
    }


}