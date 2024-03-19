package com.example.wavesoffood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CartItemBinding

class CartRvAdapter(private var cartItem:MutableList<String>, private var price:MutableList<String>, private var image:MutableList<Int>):RecyclerView.Adapter<CartRvAdapter.ViewHolder>() {

    private var itemQuantity= IntArray(cartItem.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quantity=itemQuantity[position]
        val item=cartItem[position]
        val price=price[position]
        val images=image[position]

        holder.bind(item,price,images,quantity,position)
    }

    override fun getItemCount(): Int {
        return cartItem.size
    }

    inner class ViewHolder(private val binding: CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        private val imageView=binding.imageFood

        fun bind(item: String, price: String, images: Int, quantity: Int,position: Int) {
            binding.tvNumber.text= quantity.toString()
            binding.foodName.text=item
            binding.price.text=price
            imageView.setImageResource(images)

            binding.ivDelete.setOnClickListener{
               val itemPosition=adapterPosition
                if(itemPosition!=RecyclerView.NO_POSITION){
                    onDelete(itemPosition)
                }

            }

            binding.ivNegative.setOnClickListener{
                onDecreaseQuantity(position)
            }
            binding.ivPositive.setOnClickListener{
                onIncreaseQuantity(position)
            }
        }


       private fun onDelete(position:Int){
           cartItem.removeAt(position)
           price.removeAt(position)
           image.removeAt(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItem.size)
        }
        private fun onDecreaseQuantity(position: Int){
            if(itemQuantity[position]>1)
            {
                itemQuantity[position]--
                binding.tvNumber.text=itemQuantity[position].toString()
            }
        }
        private fun onIncreaseQuantity(position: Int) {

                if(itemQuantity[position]<10)
                {
                    itemQuantity[position]++
                    binding.tvNumber.text=itemQuantity[position].toString()
                }

        }
    }


}