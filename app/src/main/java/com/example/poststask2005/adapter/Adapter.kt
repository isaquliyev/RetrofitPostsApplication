package com.example.poststask2005.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poststask2005.R
import com.example.poststask2005.model.Posts

class Adapter(list: List<Posts>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list : List<Posts>

    init {
        this.list = list
    }

    inner class ViewHolder( itemView : View) : RecyclerView.ViewHolder(itemView) {
        var userId = itemView.findViewById<TextView>(R.id.userId)
        var id = itemView.findViewById<TextView>(R.id.id)
        var titleId = itemView.findViewById<TextView>(R.id.titleId)
        var bodyId = itemView.findViewById<TextView>(R.id.bodyId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.recycler_row, parent , false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder : ViewHolder , position : Int ) {
        holder.userId.setText(list.get(position).userId.toString())
        holder.id.setText(list.get(position).id.toString())
        holder.titleId.setText(list.get(position).title)
        holder.bodyId.setText(list.get(position).body)
    }
}