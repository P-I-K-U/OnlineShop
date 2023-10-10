package com.example.onlineshop.register

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivitySignInBinding
import com.example.onlineshop.main.MainActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createNewAccBtn.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        binding.signInBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}