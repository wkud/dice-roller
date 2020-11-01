package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonD100.setOnClickListener {
            resultTextView.text = randomize(6)
        }

    }

    private fun randomize(diceType: Int): String {
        val random = Random()
        val number = random.nextInt(6) + 1
        return number.toString()
    }
}