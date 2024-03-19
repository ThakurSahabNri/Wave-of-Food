package com.example.wavesoffood.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.MenuAdapter
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentSearchBinding



class SearchFragment : Fragment() {
lateinit var binding: FragmentSearchBinding
private lateinit var adapter: MenuAdapter

    //These lists represent the original menu data, including food names, prices, and images.
    private val originalFoodMenuName= mutableListOf<String>("Burger","Sandwich","Samosa","Item",
        "Burger","Sandwich","Samosa","Item")
    private val originalPriceMenu= mutableListOf<String>("$5","$4","$1","$8","$5","$4","$1","$8")
    private val originalImageMenu=
        mutableListOf<Int>(R.drawable.photo_menu1,R.drawable.photo_menu2,R.drawable.photo_menu3,
            R.drawable.logo,R.drawable.photo_menu1,R.drawable.photo_menu2,
            R.drawable.photo_menu3,R.drawable.logo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

//These lists will be used to store the filtered menu data based on the search query.
    private  val filteredMenuItemName= mutableListOf<String>()
    private  val filteredMenuPrice= mutableListOf<String>()
    private  val filteredMenuImage= mutableListOf<Int>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSearchBinding.inflate(layoutInflater, container, false)

        adapter=MenuAdapter(filteredMenuItemName,filteredMenuPrice,filteredMenuImage,requireContext())
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter=adapter

        //setting search view
         SetUpSearchView()
       //show all menu items
        showAllMenuItems()
        return binding.root
    }

    //Clears the filtered lists and adds all the original menu items to them.
    private fun showAllMenuItems() {
        filteredMenuImage.clear()
        filteredMenuPrice.clear()
        filteredMenuItemName.clear()

        filteredMenuItemName.addAll(originalFoodMenuName)
        filteredMenuPrice.addAll(originalPriceMenu)
        filteredMenuImage.addAll(originalImageMenu)
        adapter.notifyDataSetChanged()
    }

    //Sets up the SearchView to listen for query changes and submissions.
    private fun SetUpSearchView() {
       binding.svSearch.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
           override fun onQueryTextSubmit(query: String): Boolean {

               filtermenuItems(query)
               return true
           }

           override fun onQueryTextChange(newText: String): Boolean {
              filtermenuItems(newText)
               return true
           }

       })



    }

    //Clears the filtered lists.
    //Iterates through the original menu items and adds items that match the query to the filtered lists.
    private fun filtermenuItems(query: String) {
        filteredMenuImage.clear()
        filteredMenuPrice.clear()
        filteredMenuItemName.clear()

        originalFoodMenuName.forEachIndexed { index, foodName ->
            if(foodName.contains(query,ignoreCase = true)){
               filteredMenuItemName.add(foodName)
               filteredMenuPrice.add(originalPriceMenu[index])
               filteredMenuImage.add(originalImageMenu[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}


