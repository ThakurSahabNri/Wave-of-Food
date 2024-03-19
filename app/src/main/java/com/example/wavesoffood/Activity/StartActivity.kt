package com.example.wavesoffood.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.wavesoffood.R

class StartActivity : AppCompatActivity() {
    lateinit var nextButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        nextButton=findViewById(R.id.nextButton)

        nextButton.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }

    }
}