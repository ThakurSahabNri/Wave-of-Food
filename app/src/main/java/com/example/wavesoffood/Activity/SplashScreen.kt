package com.example.wavesoffood.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.wavesoffood.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splas_screen)

        Handler().postDelayed({
            val intent=Intent(this, StartActivity::class.java)
            startActivity(intent)
        },3000)
    }
}