package com.example.tipcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val userInput = findViewById<EditText>(R.id.editTextText2)

        val radioGroupButton = findViewById<RadioGroup>(R.id.radioGroup)

        val radioButton1 = findViewById<RadioButton>(R.id.radioButton)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)

        val switchButton = findViewById<Switch>(R.id.switch1)

        val calculate = findViewById<Button>(R.id.button)

        val tipResult = findViewById<TextView>(R.id.textView5)

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
                var calculatedTip = tipInput * servicePercentage

                tipResult.text = "Tip Amount: $calculatedTip"

                if (switchButton.isChecked) {
                    calculatedTip = kotlin.math.ceil(calculatedTip)
                    tipResult.text = "Tip Amount: $calculatedTip"
                }
            } else {
                tipResult.text = "Tip Amount: "
                // Handle invalid input
                Toast.makeText(this, "Invalid or empty tip amount", Toast.LENGTH_SHORT).show()
            }

        }
    }

}