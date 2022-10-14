package com.benako.todo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benako.todo.R
import com.benako.todo.data.Todos
import kotlin.reflect.KFunction1

class ListViewAdapter(
    val list: MutableList<Todos>,
    val removeItem: KFunction1<TextView, Unit>,
    val uncheckItem: KFunction1<TextView, Unit>
) :
    RecyclerView.Adapter<ListViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //what is going in
        var title: TextView = view.findViewById(R.id.todoItem)
        var checkBox: CheckBox = view.findViewById(R.id.check_box)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder { //what item layout to use
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) { // what order to put items in
        val todo = list[position]
        holder.title.text = todo.title
        holder.checkBox.setOnClickListener {
            var isChecked = holder.checkBox.isChecked
            when (isChecked) {
                true -> removeItem(holder.title)
                else -> uncheckItem(holder.title)
            }
        }
    }

    override fun getItemCount(): Int { // how many items are there in your lists
        return list.size
    }
}