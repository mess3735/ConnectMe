package com.messamraza.i221194

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharScreen : AppCompatActivity() {
    private lateinit var adapter: MessageAdapter
    private lateinit var messageInput: EditText
    private lateinit var chatRecyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_char_screen)

        // Ensure "main" ID exists in XML to prevent crashes
        val mainLayout = findViewById<ViewGroup>(R.id.main) ?: throw IllegalStateException("main ID missing in XML")
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI elements
        val backButton = findViewById<ImageView>(R.id.backButton)
        val viewProfileButton = findViewById<Button>(R.id.viewProfileButton)
        messageInput = findViewById(R.id.messageInput)
        val sendBtn = findViewById<ImageButton>(R.id.sendBtn)
        chatRecyclerView = findViewById(R.id.chatRecyclerView)

        // Handle Navigation
        backButton.setOnClickListener {
            startActivity(Intent(this, SearchPage::class.java))
            finish()
        }

        viewProfileButton.setOnClickListener {
            startActivity(Intent(this, EditPage::class.java))
            finish()
        }

        // Create and populate message list
        val list = mutableListOf(
            MessageModle("Hi! Umar Shahzad here", true, "10:30 AM"),
            MessageModle("Hey! Messam here!", false, "10:32 AM")
        )

        // Set up RecyclerView with adapter
        adapter = MessageAdapter(list)
        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.adapter = adapter

        // Handle Message Sending
        sendBtn.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val message = messageInput.text.toString().trim()
        if (message.isNotEmpty()) {
            adapter.addMessage(MessageModle(message, true, "Now"))
            chatRecyclerView.scrollToPosition(adapter.itemCount - 1) // Ensure scrolls to latest message
            messageInput.text.clear()
        }
    }
}
