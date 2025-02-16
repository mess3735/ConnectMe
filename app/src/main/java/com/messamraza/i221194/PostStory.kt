package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PostStory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_post_story)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var backButton = findViewById<ImageView>(R.id.closeButton)
        backButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        var nextButton = findViewById<TextView>(R.id.nextButton)
        nextButton.setOnClickListener {
            var intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
            finish()
        }
    }
}