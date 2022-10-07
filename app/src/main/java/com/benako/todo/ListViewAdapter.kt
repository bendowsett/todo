package com.benako.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benako.todo.data.Todos

class ListViewAdapter(val list : List<Todos> ) :
    RecyclerView.Adapter<ListViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        //what is going in
        var title : TextView = view.findViewById(R.id.todoItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder { //what item layout to use
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) { // what order to put items in
        val todo = list[position]
        holder.title.text = todo.title
    }

    override fun getItemCount(): Int { // how many items are there in your lists
        return list.size
    }
}