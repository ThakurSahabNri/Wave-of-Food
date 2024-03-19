package com.example.wavesoffood.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wavesoffood.Activity.MainActivity
import com.example.wavesoffood.databinding.FragmentCongratesBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CongratsBottomSheetFragment : BottomSheetDialogFragment() {
    lateinit var binding:FragmentCongratesBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentCongratesBottomSheetBinding.inflate(inflater,container,false)

        binding.btnGoHome.setOnClickListener{
            startActivity(Intent(context,MainActivity::class.java))
           dismiss()
        }
        return binding.root
    }

    companion object {
     
    }
}