package com.example.wavesoffood.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.PreviousAdapter

import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentHistoryBinding



class HistoryFragment : Fragment() {

    lateinit var binding:FragmentHistoryBinding
    lateinit var adapter:PreviousAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHistoryBinding.inflate(layoutInflater, container, false)

       setUpAdapter()

        return binding.root
    }

    companion object {

    }
    fun setUpAdapter(){
       val previousFoodName= arrayListOf<String>("FoodName1","FoodName2","FoodName3")
        val previousPrice= arrayListOf<String>("$7","$9","$4")
        val previousImage= arrayListOf<Int>(R.drawable.photo_menu1,R.drawable.photo_menu2,R.drawable.photo_menu3)
        adapter= PreviousAdapter(previousFoodName,previousPrice,previousImage)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())

    }
}