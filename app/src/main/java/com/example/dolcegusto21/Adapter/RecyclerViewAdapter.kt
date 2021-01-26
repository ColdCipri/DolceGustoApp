package com.example.dolcegustoapp.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dolcegusto21.R
import com.example.dolcegustoapp.Model.Gusto


class RecyclerViewAdapter(private var context: Context ,
                          private var items: List<Gusto>
    ) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val itemTitles = arrayOf("Text1", "Text2")

    private val itemImages = intArrayOf(
        R.drawable.starbucks_cappucino,
        R.drawable.starbucks_caramel_macchiato
    )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var thumbnail: ImageView

        init {
            title = itemView.findViewById(R.id.id_gusto_textview) as TextView
            thumbnail = itemView.findViewById(R.id.id_gusto_imageview) as ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].name
        holder.thumbnail.setImageDrawable(items[position].picture)

        holder.itemView.setOnClickListener{v: View ->

            Toast.makeText(v.context, "Clicked on " + holder.title.text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Gusto>) {
        items = newItems
    }
}