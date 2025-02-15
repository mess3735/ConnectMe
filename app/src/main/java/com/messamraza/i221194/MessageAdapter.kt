package com.messamraza.i221194

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(private var list: MutableList<MessageModle>) :
    RecyclerView.Adapter<MessageAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chats, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val message = list[position]

        if (message.isSent) {
            holder.sentMessage.text = message.messageText
            holder.sentTime.text = message.timestamp
            holder.sentMessage.visibility = View.VISIBLE
            holder.sentTime.visibility = View.VISIBLE
            holder.receivedMessage.visibility = View.GONE
            holder.receivedTime.visibility = View.GONE
        } else {
            holder.receivedMessage.text = message.messageText
            holder.receivedTime.text = message.timestamp
            holder.receivedMessage.visibility = View.VISIBLE
            holder.receivedTime.visibility = View.VISIBLE
            holder.sentMessage.visibility = View.GONE
            holder.sentTime.visibility = View.GONE
        }
    }

    fun addMessage(message: MessageModle) {
        list.add(message)
        notifyItemInserted(list.size - 1)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val receivedMessage: TextView = itemView.findViewById(R.id.receivedMessage)
        val receivedTime: TextView = itemView.findViewById(R.id.receivedTime)
        val sentMessage: TextView = itemView.findViewById(R.id.sentMessage)
        val sentTime: TextView = itemView.findViewById(R.id.sentTime)
    }
}
