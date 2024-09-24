package com.example.tipcalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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

        val radioGroupButton = findViewById<RadioGroup>(R.id.radioGroup)

        val radioButton1 = findViewById<RadioButton>(R.id.radioButton)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)

        val switch1 = findViewById<Switch>(R.id.switch1)

        val calculate = findViewById<Button>(R.id.button)

        calculate.setOnClickListener {
            //we get the user input from the edit Text by assigning it to a new variable
            val tipInput = userInput.text.toString().toDoubleOrNull()

            // Display the input
            Log.d("MyApp", "You entered: $tipInput")

            if (tipInput != null) {

                var servicePercentage = 0.0

                when (radioGroupButton.checkedRadioButtonId ) {
                    R.id.radioButton -> servicePercentage = 0.20 // Amazing
                    R.id.radioButton2 -> servicePercentage = 0.18 // Good
                    R.id.radioButton3 -> servicePercentage = 0.15 // OK
                }

                // Calculate the tip
                val calculatedTip = tipInput * servicePercentage

                // Log the result for now
                Log.d("MyApp", "Calculated Tip: $calculatedTip")

                // Show the result using a Toast
                Toast.makeText(this, "Calculated Tip: $calculatedTip", Toast.LENGTH_LONG).show()
            } else {
                // Handle invalid input
                Log.d("MyApp", "Invalid or empty tip amount")
            }

        }
    }

}