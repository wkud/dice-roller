package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val equationStringBuilder = StringBuilder()
    private var totalResult = 0
    private var rolled = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRoll.setOnClickListener {
            onRollButtonClick()
        }

        val buttons = mapOf(
            buttonD100 to 100, buttonD20 to 20, buttonD12 to 12,
            buttonD10 to 10, buttonD8 to 8, buttonD6 to 6,
            buttonD4 to 4, buttonD3 to 3, buttonD2 to 2
        )

        //attach onDiceButtonClick to every button; every button has unique 'diceType' parameter
        for (button in buttons.keys) {
            button.setOnClickListener {
                val diceType = buttons[button]
                onDiceButtonClick(diceType!!.toInt())
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun onRollButtonClick() {
        resultTextView.text = "= $totalResult"
        rolled = true
    }

    private fun onDiceButtonClick(diceType: Int) {
        tryClear()

        val randomNumber = randomize(diceType)
        totalResult += randomNumber

        if (equationStringBuilder.isEmpty()) {
            equationStringBuilder.append("d$diceType")
        } else {
            equationStringBuilder.append("+d$diceType")
        }
        equationTextView.text = equationStringBuilder.toString()
    }

    private fun randomize(diceType: Int): Int {
        val random = Random()
        return random.nextInt(diceType) + 1
    }

    private fun tryClear() {
        if (rolled) {
            equationStringBuilder.clear()
            resultTextView.text = "_"
            totalResult = 0
            rolled = false
        }
    }

}