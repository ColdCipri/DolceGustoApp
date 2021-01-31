package com.example.dolcegustoapp.Adapter


import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dolcegusto21.Activity.DetailsActivity
import com.example.dolcegusto21.R
import com.example.dolcegustoapp.Model.Gusto
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview_item.view.*
import java.io.File


class RecyclerViewAdapter(private var context: Context ,
                          private var items: List<Gusto>
    ) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_item, parent, false)
        return ViewHolder(v, null)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.id_cardview_title?.text = items[position].name
        holder.itemView.id_cardview_title?.setBackgroundColor(Color.parseColor(items[position].predominantColor))
        holder.itemView.id_cardview_text_color?.setBackgroundColor(Color.parseColor(items[position].predominantColor))

        holder.itemView.id_cardview_image.setImageDrawable(items[position].imageURL)

        holder.item = items[position]
    }

    class ViewHolder(itemView: View, var item: Gusto?) : RecyclerView.ViewHolder(itemView) {
        companion object{
            val ITEM_TITLE = "item_name"
            val ITEM_COLOR = "item_color"
        }

        init {
            itemView.setOnClickListener{
                val intent = Intent(itemView.context, DetailsActivity::class.java)

                intent.putExtra(ITEM_TITLE, item?.name)
                intent.putExtra(ITEM_COLOR, item?.predominantColor)
                itemView.context.startActivity(intent)
            }
        }
    }
}