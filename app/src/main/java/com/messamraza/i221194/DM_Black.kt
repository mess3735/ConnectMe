package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DM_Black : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dm_black)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var backBtn = findViewById<ImageView>(R.id.backButton)
        backBtn.setOnClickListener {
            var intent = Intent(this, DMs::class.java)
            startActivity(intent)
            finish()
        }
        var veiwProfile = findViewById<Button>(R.id.viewProfileButton)
        veiwProfile.setOnClickListener {
            var intent = Intent(this, ContactsContract.Profile::class.java)
            startActivity(intent)
            finish()
        }
    }
}