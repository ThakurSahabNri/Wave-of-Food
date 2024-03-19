package com.example.wavesoffood.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.NotificationAdapter
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentNotificationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationFragment : BottomSheetDialogFragment() {
   lateinit var binding:FragmentNotificationBinding
    private val notifications= arrayListOf<String>("Your order has been Canceled Successfully",
        "Order has been taken by the driver",
        "Congrats Your Order Placed")

    private val notificationImages= arrayListOf<Int>(
        R.drawable.sademoji,
        R.drawable.icon__car_2,
        R.drawable.successfull
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentNotificationBinding.inflate(layoutInflater,container,false)



        val adapter= NotificationAdapter(notifications,notificationImages)
        binding.recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter=adapter
        
        binding.imageButton.setOnClickListener{
            dismiss()
        }

        return binding.root
    }

    companion object {

    }
}