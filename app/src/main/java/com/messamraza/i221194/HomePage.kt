package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
            var intent = Intent(this, EditPage::class.java)
            startActivity(intent)
            finish()
        }
        var contact = findViewById<ImageView>(R.id.contact)
        contact.setOnClickListener {
            var intent = Intent(this, Contacts::class.java)
            startActivity(intent)
            finish()
        }
        var addPost = findViewById<ImageView>(R.id.addPost)
        addPost.setOnClickListener {
            var intent = Intent(this, PostShare::class.java)
            startActivity(intent)
            finish()
        }
        var dms = findViewById<ImageButton>(R.id.dms)
        dms.setOnClickListener {
            var intent = Intent(this, DMs::class.java)
            startActivity(intent)
            finish()
        }
//        var recyclerViewStories = findViewById<RecyclerView>(R.id.recyclerViewStories)
//        recyclerViewStories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        var storiesAdapter = StoriesAdapter(this)
//        recyclerViewStories.adapter = storiesAdapter
//
    }
}