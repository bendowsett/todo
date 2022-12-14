package com.benako.todo.ui

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.benako.todo.data.Todos
import com.benako.todo.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    private lateinit var binding: FragmentListBinding

    var adapter = ListViewAdapter(viewModel.exampleTodos.value!!, ::deleteNote, ::uncheck)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        var adapter = ListViewAdapter(viewModel.exampleTodos.value!!, ::deleteNote, ::uncheck)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.recyclerView.adapter = adapter

        binding.addNoteButton.setOnClickListener {
            addNote()
            adapter.notifyDataSetChanged()

        }
        return binding.root // root of the view from list fragment.
    }

    fun addNote() {
        var input = binding.noteInput.text.toString()
        viewModel.addToDo(input)
        binding.noteInput.text.clear()

    }

    fun deleteNote(text: TextView) {
        text.paintFlags = text.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    fun uncheck(text: TextView) {
        text.setPaintFlags(0)
    }
}



