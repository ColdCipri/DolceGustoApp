package com.example.dolcegusto21.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dolcegusto21.R
import com.example.dolcegustoapp.Adapter.RecyclerViewAdapter
import com.example.dolcegustoapp.Model.Gusto
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this) //This is used for 2 items on each line GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager

        val listOfCoffee:ArrayList<Gusto> = ArrayList()

        fillList(listOfCoffee)


        adapter = RecyclerViewAdapter(this, listOfCoffee)
        recyclerView.adapter = adapter

    }

    private fun fillList(listOfCoffee: ArrayList<Gusto>) {
        listOfCoffee.add(Gusto("Starbucks Cappucino",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_cappucino,null ),"#815f5d"))

        listOfCoffee.add(Gusto("Starbucks Caramel Machiato",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_caramel_macchiato,null ),"#ce732a"))

        listOfCoffee.add(Gusto("Starbucks Blonde Espresso Roast",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_blonde_espresso_roast,null ),"#f9b400"))

        listOfCoffee.add(Gusto("Starbucks Caffe Latte",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_caffe_latte,null ),"#b27a6b"))

        listOfCoffee.add(Gusto("Starbucks Espresso Roast",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_espresso_roast,null ),"#365162"))

        listOfCoffee.add(Gusto("Starbucks House Blend",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_house_blend,null ),"#965f36"))

        listOfCoffee.add(Gusto("Starbucks Latte Machiato",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_latte_macchiato,null ),"#d9bc9a"))

        listOfCoffee.add(Gusto("Starbucks Single Origin Colombia",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_single_origin_colombia,null ),"#dd4712"))

        listOfCoffee.add(Gusto("Starbucks Toffe Nut Latte",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_toffee_nut_latte,null ),"#fdd5cd"))

        listOfCoffee.add(Gusto("Starbucks Veranda Blend",
            ResourcesCompat.getDrawable(resources, R.drawable.starbucks_veranda_blend,null ),"#dfbf36"))
    }


}