package com.example.nursingstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val mobile = findViewById<EditText>(R.id.etMobile).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            if (mobile.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
