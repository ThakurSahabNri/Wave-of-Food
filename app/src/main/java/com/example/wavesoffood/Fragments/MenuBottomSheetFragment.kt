package com.example.wavesoffood.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.MenuAdapter
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMenuBottomSheetBinding.inflate(layoutInflater, container, false)


        binding.backButton.setOnClickListener { dismiss() }

        val foodMenuName= mutableListOf<String>("Burger","Sandwich","Samosa","Item","Burger","Sandwich","Samosa","Item")
        val priceMenu= mutableListOf<String>("$5","$4","$1","$8","$5","$4","$1","$8")
        val imageMenu=
            mutableListOf<Int>(
                R.drawable.photo_menu1, R.drawable.photo_menu2, R.drawable.photo_menu3,
                R.drawable.logo, R.drawable.photo_menu1, R.drawable.photo_menu2,
                R.drawable.photo_menu3, R.drawable.logo
            )

        val adapter= MenuAdapter(foodMenuName,priceMenu,imageMenu,requireContext())
        binding.menuRecyclerView.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.menuRecyclerView.adapter=adapter


        return binding.root
    }

    companion object {

    }
}