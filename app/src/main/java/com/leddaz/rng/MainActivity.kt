package com.leddaz.rng

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.DynamicColors
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DynamicColors.applyToActivityIfAvailable(this)
        setContentView(R.layout.activity_main)
    }

    /**
     * Called when the user taps the Confirm button.
     */
    @Suppress("UNUSED_PARAMETER")
    fun genNum(view: View) {
        val minNumber = findViewById<TextInputEditText>(R.id.min_input_edittext)
        val min = minNumber.text.toString()
        val maxNumber = findViewById<TextInputEditText>(R.id.max_input_edittext)
        val max = maxNumber.text.toString()
        val rnd = Random.nextInt(min.toInt(), max.toInt())
        val result = findViewById<MaterialTextView>(R.id.result_textview)
        result.text = rnd.toString()
        result.visibility = View.VISIBLE
    }
}