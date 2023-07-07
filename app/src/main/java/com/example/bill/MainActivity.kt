package com.example.bill
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var billAmount: EditText
    private lateinit var tipPercentage: EditText
    private lateinit var calculateButton: Button
    private lateinit var tipAmount: TextView
    private lateinit var totalAmount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billAmount = findViewById(R.id.billAmount)
        tipPercentage = findViewById(R.id.tipPercentage)
        calculateButton = findViewById(R.id.calculateButton)
        tipAmount = findViewById(R.id.tipAmount)
        totalAmount = findViewById(R.id.totalAmount)

        calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val billAmountValue = billAmount.text.toString().toDoubleOrNull()
        val tipPercentageValue = tipPercentage.text.toString().toDoubleOrNull()

        if (billAmountValue != null && tipPercentageValue != null) {
            val tip = billAmountValue * (tipPercentageValue / 100)
            val total = billAmountValue + tip

            val decimalFormat = DecimalFormat("#.##") // to format the tip and total value

            tipAmount.text = "Tip Amount:N$ ${decimalFormat.format(tip)}"
            totalAmount.text = "Total Amount:N$ ${decimalFormat.format(total)}"
        }
    }
}
