package com.messamraza.i221194

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var registerBtn = findViewById<Button>(R.id.registerBtns)
        registerBtn.setOnClickListener {
            val intent = Intent(this, VoiceCall::class.java)
            startActivity(intent)
        }
        var loginBtn = findViewById<TextView>(R.id.loginButtons)
        loginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




//        registerBtn.setOnClickListener {
//            var name = name.text.toString()
//            var username = username.text.toString()
//            var phone = phone.text.toString()
//            var email = email.text.toString()
//            var password = password.text.toString()
//        //var db = DBHelper(this, null)


    }
}