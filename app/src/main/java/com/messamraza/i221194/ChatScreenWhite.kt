package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatScreenWhite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_screen_white)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, SearchPage::class.java)
            startActivity(intent)
            finish()
        }

        val viewProfileButton = findViewById<Button>(R.id.viewProfileButton)
        viewProfileButton.setOnClickListener {
            val intent = Intent(this, EditPage::class.java)
            startActivity(intent)
            finish()
        }

        val messageInput = findViewById<EditText>(R.id.messageInput)
        val sendBtn = findViewById<ImageButton>(R.id.sendBtn)
        val chatRecyclerView = findViewById<RecyclerView>(R.id.chatRecyclerView)

        // Create list and populate it correctly
        val list = mutableListOf<MessageModle>()
        list.add(MessageModle("Hi! Umar Shahzad here", true, "10:30 AM"))
        list.add(MessageModle("Hey! Messam here!", false, "10:32 AM"))

        // Initialize adapter and layout manager
        val adapter = MessageAdapter(list)
        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.adapter = adapter

        sendBtn.setOnClickListener {
            val message = messageInput.text.toString().trim()
            if (message.isNotEmpty()) {
                list.add(MessageModle(message, true, "Now"))
                adapter.notifyItemInserted(list.size - 1)
                chatRecyclerView.scrollToPosition(list.size - 1)
                messageInput.text.clear()
            }
        }
    }
}
