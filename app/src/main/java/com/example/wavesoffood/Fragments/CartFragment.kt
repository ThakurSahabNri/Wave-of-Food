package com.example.wavesoffood.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.Activity.PayOutActivity
import com.example.wavesoffood.CartRvAdapter
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentCartBinding

class CartFragment : Fragment() {
 private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment


        binding=FragmentCartBinding.inflate(layoutInflater,container,false)
        val foodName= mutableListOf<String>("Burger","Sandwich","Samosa","Item")
        val price= mutableListOf<String>("$5","$4","$1","$8")
        val image=
            mutableListOf<Int>(R.drawable.photo_menu1,R.drawable.photo_menu2,R.drawable.photo_menu3,R.drawable.logo)

        val adapter= CartRvAdapter(foodName,price,image)
        binding.recyclerView.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter=adapter

        binding.btnProceed.setOnClickListener{
            startActivity(Intent(context,PayOutActivity::class.java))
        }

        return binding.root
    }

    companion object {

    }
}