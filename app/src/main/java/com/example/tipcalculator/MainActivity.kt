package com.example.tipcalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val userInput = findViewById<EditText>(R.id.editTextText2)

        val radioButton1 = findViewById<RadioButton>(R.id.radioButton)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)

        val switch1 = findViewById<Switch>(R.id.switch1)

        val calculate = findViewById<Button>(R.id.button)

        calculate.setOnClickListener {
            //we get the user input from the edit Text by assigning it to a new variable
            val tip = userInput.text.toString()

            // Display the input
            Log.d("MyApp", "You entered: $tip")


        }
    }

}