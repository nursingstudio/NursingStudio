package com.example.nursingstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OtpVerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        val mobile = intent.getStringExtra("mobile")
        val email = intent.getStringExtra("email")

        val btnVerify = findViewById<Button>(R.id.btnVerify)

        btnVerify.setOnClickListener {
            val otp = findViewById<EditText>(R.id.etOtp).text.toString()
            if (otp == "1234") { // dummy OTP
                Toast.makeText(this, "OTP Verified", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
