package com.example.dolcegusto21.Activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dolcegusto21.R
import com.example.dolcegustoapp.Adapter.RecyclerViewAdapter
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

        var isWorking = false

        val chronometer = findViewById<Chronometer>(R.id.id_fragment_chronometer)

        chronometer.isCountDown = true  //Set count down
        chronometer.base = SystemClock.elapsedRealtime() + 3000    //Set timer to 10 seconds to show when open the activity

        chronometer.onChronometerTickListener = OnChronometerTickListener {
            if (SystemClock.elapsedRealtime() -chronometer.base >= 1L) {
                chronometer.base = SystemClock.elapsedRealtime()
                Toast.makeText(this@DetailsActivity, "Bing!", Toast.LENGTH_SHORT).show()
                chronometer.stop()
                button_start.setText(R.string.start) //Switch text
                isWorking = false
                chronometer.base = SystemClock.elapsedRealtime() + 3000    //Set timer to 10 seconds to show
            }
        }

        var pauseOffset: Long = 0

        var isStarted = false
        findViewById<Button>(R.id.button_start).setOnClickListener(object : View.OnClickListener {


            override fun onClick(v: View) {
                if (!isStarted) {
                    chronometer.base = SystemClock.elapsedRealtime() + 3000    //Sets the 10 second timer to start only when click is pressed
                    isStarted = true
                }
                if (!isWorking) {
                    chronometer.base = SystemClock.elapsedRealtime() + 3000 - pauseOffset
                    chronometer.start()
                    isWorking = true
                } else {
                    chronometer.stop()
                    pauseOffset = SystemClock.elapsedRealtime() + 3000 - chronometer.base  //Resume timer from where it left
                    isWorking = false
                }
                button_start.setText(if (isWorking) R.string.pause else R.string.start) //Switch text

                Toast.makeText(this@DetailsActivity, getString(
                        if (isWorking)
                            R.string.working
                        else
                            R.string.stopped),
                        Toast.LENGTH_SHORT).show()
            }
        })

        findViewById<Button>(R.id.button_restart).setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime() + 3000
            pauseOffset = 0
        }
    }
}