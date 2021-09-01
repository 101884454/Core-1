package com.example.core1

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onStop(){
        super.onStop()
        Log.i("MainActivity", "onStop Called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy Called")
    }

    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val score = findViewById<Button>(R.id.score)
        val steal = findViewById<Button>(R.id.steal)
        val reset = findViewById<Button>(R.id.reset)


        score.setOnClickListener{
            when (count) {
                in 0..14 -> {
                    count++
                    printCount()
                    soundout()
                }
            }
        }

        steal.setOnClickListener{
            if (count > 0) {
                count--
                printCount()
            }
        }

        reset.setOnClickListener{
            count = 0
            printCount()
        }

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("my_count")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("my_count", count)
    }

    private fun soundout(){
        if (count == 15){
            var mediaPlayer = MediaPlayer.create(this, R.raw.dinner_bell_triangle)
            mediaPlayer.start()
        }
    }
    private fun printCount(){
        val sum = findViewById<EditText>(R.id.sum)
        when {
            count in 5..9 -> {
                sum.setTextColor(Color.BLUE)
                sum.setText("$count")
            }
            count>9 -> {
                sum.setTextColor(Color.GREEN)
                sum.setText("$count")
            }
            else -> {
                sum.setText("$count")
                sum.setTextColor(Color.BLACK)
            }
        }
    }

}