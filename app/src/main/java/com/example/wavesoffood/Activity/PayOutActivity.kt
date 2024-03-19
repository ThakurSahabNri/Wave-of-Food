package com.example.wavesoffood.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.Fragments.CongratsBottomSheetFragment
import com.example.wavesoffood.Fragments.CartFragment
import com.example.wavesoffood.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    private val binding:ActivityPayOutBinding by lazy {
        ActivityPayOutBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnPlaceOrder.setOnClickListener{
           val bottomSheetDialog= CongratsBottomSheetFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }

        binding.backButton.setOnClickListener{
            val intent = Intent(this, CartFragment::class.java)
            startActivity(intent)
            finish()
        }
    }
}