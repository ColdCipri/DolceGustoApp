package com.example.dolcegusto21

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager

        val listOfCoffee:ArrayList<Gusto> = ArrayList<Gusto>()
        /*listOfCoffee.add(Gusto("Starbucks", ))*/

        adapter = RecyclerViewAdapter(this, listOfCoffee)
        recyclerView.adapter = adapter

    }
}