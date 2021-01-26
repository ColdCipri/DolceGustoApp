package com.example.dolcegusto21

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        listOfCoffee.add(Gusto("Starbucks Cappucino", ResourcesCompat.getDrawable(resources,R.drawable.starbucks_cappucino,null )))
        listOfCoffee.add(Gusto("Starbucks Caramel Machiato", ResourcesCompat.getDrawable(resources,R.drawable.starbucks_caramel_macchiato,null )))


        adapter = RecyclerViewAdapter(this, listOfCoffee)
        recyclerView.adapter = adapter

    }
}