package com.example.nursingstudio

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.nursingstudio.models.User

private val appcompat: Any
    get() {
        TODO()
    }

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val dob = findViewById<EditText>(R.id.etDob).text.toString()
            val sex = findViewById<Spinner>(R.id.spinnerSex).selectedItem.toString()
            val country = findViewById<EditText>(R.id.etCountry).text.toString()
            val state = findViewById<EditText>(R.id.etState).text.toString()
            val district = findViewById<EditText>(R.id.etDistrict).text.toString()
            val pinCode = findViewById<EditText>(R.id.etPinCode).text.toString()
            val mobile = findViewById<EditText>(R.id.etMobile).text.toString()
            val email = findViewById<EditText>(R.id.etEmail).text.toString()
            val education = findViewById<Spinner>(R.id.spinnerEducation).selectedItem.toString()
            val category = findViewById<Spinner>(R.id.spinnerCategory).selectedItem.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            if (name.isEmpty() || mobile.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, dob, sex, country, state, district, pinCode, mobile, email, education, category, password)
                // For now, we just pass data to OTP verification screen
                val intent = Intent(this, OtpVerificationActivity::class.java)
                intent.putExtra("mobile", user.mobile)
                intent.putExtra("email", user.email)
                startActivity(intent)
            }
        }
    }
}

private fun RegisterActivity.findViewById(etName: Any) {
    TODO("Not yet implemented")
}

private fun AppCompatActivity.onCreate(savedInstanceState: Bundle?) {
    TODO("Not yet implemented")
}
