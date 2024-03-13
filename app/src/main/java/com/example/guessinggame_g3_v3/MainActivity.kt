package com.example.guessinggame_g3_v3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var etNumber : EditText? = null
    private var tvDisp : TextView? = null
    private var intRandom: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber = findViewById<EditText>(R.id.etInput)
        tvDisp = findViewById<TextView>(R.id.tvDisplay)

        val btnGuess = findViewById<Button>(R.id.btnSubmit)
        intRandom = (1..100).shuffled().first()

        btnGuess.setOnClickListener{
            guessedNumber()
        }
    }

    private fun guessedNumber(){
        var intNumber = etNumber?.text.toString().toInt()

        if (intRandom == intNumber){
            tvDisp?.text = "= You guessed my number"
        } else {
            if (intNumber > intRandom){
                tvDisp?.text = "Your guess is larger than mine"
            } else {
                tvDisp?.text = "Your guess is less than mine"
            }
        }
    }
}