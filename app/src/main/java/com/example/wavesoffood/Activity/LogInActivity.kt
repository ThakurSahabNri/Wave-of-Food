package com.example.wavesoffood.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wavesoffood.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private val binding:ActivityLogInBinding by lazy {
         ActivityLogInBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, LocationActivity::class.java))
            finish()
        }
        binding.btnFacebook.setOnClickListener{
            Toast.makeText(this, "Facebook button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnGoogle.setOnClickListener{
            Toast.makeText(this, "Google button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.tvDHA.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

    }
}