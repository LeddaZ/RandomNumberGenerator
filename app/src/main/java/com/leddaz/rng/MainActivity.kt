package com.leddaz.rng

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt

const val EXTRA_MESSAGE = "com.leddaz.rng.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Confirm button */
    fun genNum(view: View) {
        val minNumber = findViewById<EditText>(R.id.MinTextBox)
        val min = minNumber.text.toString()
        val maxNumber = findViewById<EditText>(R.id.MaxTextBox)
        val max = maxNumber.text.toString()
        val rnd =  Random.nextInt(min.toInt(), max.toInt())
        RandomNumber.text = rnd.toString()
        RandomNumber.visibility = View.VISIBLE
    }
}