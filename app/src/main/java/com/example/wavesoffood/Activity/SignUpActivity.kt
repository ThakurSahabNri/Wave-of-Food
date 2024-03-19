package com.example.wavesoffood.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wavesoffood.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding:ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }
        binding.btnFacebook.setOnClickListener{
            Toast.makeText(this, "Facebook button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnGoogle.setOnClickListener{
            Toast.makeText(this, "Google button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.tvAHA.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }
    }
}