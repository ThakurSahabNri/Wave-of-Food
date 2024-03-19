package com.example.wavesoffood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.NotificationItemBinding

class NotificationAdapter(private val notification:ArrayList<String>,private val notificationImage:ArrayList<Int>):
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:NotificationItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(notification:String, notificationImage:Int){
            binding.tvNotification.text=notification
            binding.notificationImage.setImageResource(notificationImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding=NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notification.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.bind(notification[position],notificationImage[position])

    }

}