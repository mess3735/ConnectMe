package com.messamraza.i221194

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.messamraza.i221194.R


class MyAdapter(var list: MutableList<Modle>) : RecyclerView.Adapter<MyAdapter.MyViewHandler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHandler {
//        var  v = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
//        return MyViewHandler(v)
//
        return MyViewHandler(
            LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHandler, position: Int) {
        holder.name.text = list[position].name
    }


    class MyViewHandler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.names)

    }

}