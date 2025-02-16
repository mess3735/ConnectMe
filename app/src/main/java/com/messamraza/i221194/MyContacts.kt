package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyContacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_contacts)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            var intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }
        var edit = findViewById<ImageButton>(R.id.edit)
        edit.setOnClickListener {
            var intent = Intent(this, EditPage::class.java)
            startActivity(intent)
            finish()
        }
        var search = findViewById<ImageView>(R.id.searchbtn)
        search.setOnClickListener {
            var intent = Intent(this, SearchPage::class.java)
            startActivity(intent)
            finish()
        }
        var home = findViewById<ImageView>(R.id.home)
        home.setOnClickListener {
            var intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }
        var profile = findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {
            var intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
            finish()
        }
        var contact = findViewById<ImageView>(R.id.contact)
        contact.setOnClickListener {
            var intent = Intent(this, MyContacts::class.java)
            startActivity(intent)
            finish()
        }
        var addPost = findViewById<ImageView>(R.id.addPost)
        addPost.setOnClickListener {
            var intent = Intent(this, SharePost::class.java)
            startActivity(intent)
            finish()
        }
    }
}