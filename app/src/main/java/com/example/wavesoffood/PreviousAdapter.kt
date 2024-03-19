package com.example.wavesoffood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.wavesoffood.databinding.RecentItemBinding

class PreviousAdapter(private val previousFoodName:ArrayList<String>,private val previousFoodPrice:ArrayList<String>,
                      private val previousFoodImage:ArrayList<Int>):RecyclerView.Adapter<PreviousAdapter.ViewHolder>() {
    inner class ViewHolder(private var binding:RecentItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(previousFoodName: String,previousFoodPrice: String,previousFoodImage:Int){
            binding.previousFoodName.text=previousFoodName
            binding.previousPrice.text=previousFoodPrice
            binding.previousFoodImage.setImageResource(previousFoodImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=RecentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return previousFoodName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(previousFoodName[position],previousFoodPrice[position],previousFoodImage[position])
    }
}