package com.example.dolcegusto21.Activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dolcegusto21.R
import com.example.dolcegustoapp.Adapter.RecyclerViewAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details)

        val title = intent.getStringExtra(RecyclerViewAdapter.ViewHolder.ITEM_TITLE)
        supportActionBar?.title = title

        val predominantColor = intent.getStringExtra(RecyclerViewAdapter.ViewHolder.ITEM_COLOR)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor(predominantColor)))
        id_fragment_linearLayout.setBackgroundColor(Color.parseColor(predominantColor))

        /*val imageURL = intent.getStringExtra(RecyclerViewAdapter.ViewHolder.ITEM_IMAGE)
        id_fragment_image.setImageResource(R.drawable.starbucks_cappucino!!)
        //Picasso.get().load(imageURL).into(id_fragment_image)*/

    }
}