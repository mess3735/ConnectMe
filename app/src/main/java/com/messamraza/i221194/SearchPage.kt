package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.messamraza.i221194.Modle
import com.messamraza.i221194.MyAdapter

class SearchPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_page)
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

        val rv1 = findViewById<RecyclerView>(R.id.searchResultsRecyclerView)

        // Create list and populate it correctly
        val list1 = mutableListOf<Modle>()
        list1.add(Modle("Umar Shahzad"))
        list1.add(Modle("Messam Raza"))
        list1.add(Modle("Hamza Mir"))
        list1.add(Modle("Hamna Mir"))
        list1.add(Modle("Arham Mir"))
        list1.add(Modle("Hadiya Kamran"))

        // Initialize adapter and layout manager
        val adapter = MyAdapter(list1)
        val ll1 = LinearLayoutManager(this)

        rv1.layoutManager = ll1
        rv1.adapter = adapter
    }
}