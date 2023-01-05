package com.example.ottstudio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.widget.Button
import android.widget.Toast
import android.widget.EditText

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    lateinit var etEmail: EditText
    lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var tvRedirectlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sigup)
        auth = Firebase.auth
        tvRedirectlogin = findViewById(R.id.rlogin)
        etEmail = findViewById(R.id.email)
        etPass = findViewById(R.id.password)
        btnSignUp = findViewById(R.id.button)
        btnSignUp.setOnClickListener {
            signUpUser()
        }
        tvRedirectlogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            // using finish() to end the activity

        }

    }
    private fun signUpUser() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()

        // check pass


        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}