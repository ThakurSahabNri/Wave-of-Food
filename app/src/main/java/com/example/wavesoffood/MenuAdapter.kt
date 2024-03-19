package com.example.wavesoffood

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.MenuItemBinding

class MenuAdapter(private var menuItem:MutableList<String>, private var menuPrice:MutableList<String>,
                  private var menuImage:MutableList<Int>,private val context: Context):
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    class ViewHolder(private val binding:MenuItemBinding):RecyclerView.ViewHolder(binding.root){
            private val imageView=binding.imageMenu
            fun bind(item: String, price: String, images: Int) {
                binding.menuName.text=item
                binding.menuPrice.text=price
                imageView.setImageResource(images)

                binding.cvRestaurant.setOnClickListener{
                    val intent= Intent(binding.root.context,FoodDetailActivity::class.java)
                    intent.putExtra("MenuItemName",item)
                    intent.putExtra("MenuItemImage",images)
                    binding.root.context.startActivity(intent)

                }
            }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding=MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return menuItem.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item=menuItem[position]
        val price=menuPrice[position]
        val images=menuImage[position]

        holder.bind(item,price,images)
    }

}