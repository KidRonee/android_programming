package com.example.age_calculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null
    private var tvAgeInMinutes : TextView? = null
    private var tvAgeInHours : TextView? = null
    private var tvAgeInDays: TextView? = null
    private var tvAgeInMonths: TextView? = null
    private var tvAgeInYears: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.buttobtnDatePicker)

        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)
        tvAgeInHours = findViewById(R.id.tvAgeInHours)
        tvAgeInDays = findViewById(R.id.tvAgeInDays)
        tvAgeInMonths = findViewById(R.id.tvAgeInMonths)
        tvAgeInYears = findViewById(R.id.tvAgeInYears)

        btnDatePicker.setOnClickListener {
            clickDatePicker()

        }
    }

    private fun clickDatePicker() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this,
                    "Year was $selectedYear, " +
                            "month was ${selectedMonth + 1}, " +
                            "day of month was $selectedDayOfMonth",
                    Toast.LENGTH_SHORT).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                theDate?.let {
                    val selectedDateInMinutes = theDate.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / 60000

                        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                        val differenceInHours: Long = differenceInMinutes / 60
                        val differenceInDays: Long = differenceInHours / 24
                        val differenceInMonths: Int = (differenceInDays / 30.4368499).roundToInt()
                        val differenceInYears: Int = differenceInMonths / 12

                        tvAgeInMinutes?.text = differenceInMinutes.toString()
                        tvAgeInHours?.text = differenceInHours.toString()
                        tvAgeInDays?.text = differenceInDays.toString()
                        tvAgeInMonths?.text = differenceInMonths.toString()
                        tvAgeInYears?.text = differenceInYears.toString()
                    }
                }
            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()


    }
}