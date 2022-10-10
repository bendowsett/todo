package com.benako.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.benako.todo.data.Todos
import com.benako.todo.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding

    var exampleTodos = listOf(
        Todos("Washing, based lamb"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running24rfhwoiruthvgiurghwiurhtgurt4hogwirthginrt"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running"),
        Todos("cooking, Running")

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.recyclerView.adapter = ListViewAdapter(exampleTodos)
        return binding.root // root of the view from list fragment.
    }


}