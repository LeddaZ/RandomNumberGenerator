package com.leddaz.rng

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Called when the user taps the Confirm button.
     */
    @Suppress("UNUSED_PARAMETER")
    fun genNum(view: View) {
        val minNumber = findViewById<EditText>(R.id.MinTextBox)
        val min = minNumber.text.toString()
        val maxNumber = findViewById<EditText>(R.id.MaxTextBox)
        val max = maxNumber.text.toString()
        val rnd = Random.nextInt(min.toInt(), max.toInt())
        val result = findViewById<TextView>(R.id.RandomNumber)
        result.text = rnd.toString()
        result.visibility = View.VISIBLE
    }
}