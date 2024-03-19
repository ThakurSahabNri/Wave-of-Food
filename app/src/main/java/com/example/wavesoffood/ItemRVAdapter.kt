package com.example.wavesoffood

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.PopularItemBinding

class ItemRVAdapter( private var item:Array<String>, private var price:Array<String>, private var image:Array<Int>,
                     val requiredContext: Context):RecyclerView.Adapter<ItemRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding:PopularItemBinding):RecyclerView.ViewHolder(binding.root) {
        private val imageView=binding.imageFood
        fun bind(item: String, price: String, images: Int) {
          binding.foodName.text=item
            binding.price.text=price
            imageView.setImageResource(images)

            binding.cvRestaurent.setOnClickListener{
                val intent=Intent(requiredContext,FoodDetailActivity::class.java)
                intent.putExtra("MenuItemName",item)
                intent.putExtra("MenuItemImage",images)
                requiredContext.startActivity(intent)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding=PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
       return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=item[position]
        val price=price[position]
        val images=image[position]

      holder.bind(item,price,images)


    }
}