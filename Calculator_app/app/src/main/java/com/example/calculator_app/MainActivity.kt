package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view:View) {
        tvInput?.append((view as Button).text)
        lastDot = false
        lastNumeric = true
    }

    fun onClear(view : View) {
        tvInput?.text = ""
    }

    fun onDecimalPoint(view : View) {
        if(lastNumeric && !lastDot) {
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view : View) {
        tvInput?.text?.let {

            if (lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual(view :View) {
        if(lastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""
            try {

                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1) // gets rid of the first entry to avoid application crash...
                }

                calculate(tvValue, prefix)
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun calculate(tvValue: String, prefix: String) {
        var _operator = ""
        for (value in tvValue)
            if ((!value.isDigit() && !value.equals("."))) _operator = value.toString()

        val splitValue = tvValue.split("[*/+\\-]".toRegex())
        var one = splitValue[0]
        val two = splitValue[1]

        if (prefix.isNotEmpty())
            one = prefix + one

        when (_operator) {
            "*" -> tvInput?.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
            "/" -> tvInput?.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
            "+" -> tvInput?.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
            "-" -> tvInput?.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
        }
    }

    private fun removeZeroAfterDot(result : String) : String {
        var value = result
        if (result.contains(".0"))
            value = result.substring(0, result.length - 2)
        return value
    }

    private fun isOperatorAdded(value : String) : Boolean {
        return if(value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }
}