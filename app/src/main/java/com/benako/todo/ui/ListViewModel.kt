package com.benako.todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benako.todo.data.Todos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(): ViewModel()  {

    private val _exampleTodos = MutableLiveData<MutableList<Todos>>()
    val exampleTodos get() = _exampleTodos



    fun addToDo(todo: String){
        exampleTodos.value!!.add(Todos(todo))
    }


}