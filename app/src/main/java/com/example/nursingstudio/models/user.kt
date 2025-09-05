package com.example.nursingstudio.models

data class User(
    val name: String,
    val dob: String,
    val sex: String,
    val country: String,
    val state: String,
    val district: String,
    val pinCode: String,
    val mobile: String,
    val email: String,
    val education: String,
    val category: String,
    val password: String
)
