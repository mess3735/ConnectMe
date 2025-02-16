package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DMs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dms)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var backBtn = findViewById<ImageView>(R.id.back)
        backBtn.setOnClickListener {
            var intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }
        var dms = findViewById<Button>(R.id.DMS)
        dms.setOnClickListener {
            var intent = Intent(this, DM_White::class.java)
            startActivity(intent)
            finish()
        }

        var requests = findViewById<Button>(R.id.requests)
        requests.setOnClickListener {
            var intent = Intent(this, DM_Black::class.java)
            startActivity(intent)
            finish()
        }
    }
}