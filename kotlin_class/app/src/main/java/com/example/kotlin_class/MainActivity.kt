package com.example.kotlin_class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickMe = findViewById<Button>(R.id.myButton)
        val nameViewer = findViewById<TextView>(R.id.myName)
        val people = listOf("Jeffery", "Henrik", "Philip", "Leroy", "Cockbreath")

        var timesClicked = 0
        btnClickMe.setOnClickListener {
            val randomName = people.random()
            timesClicked++
            nameViewer.text = "Speak... or FUCK OFF! ${randomName}"
            Toast.makeText(this, "Hey I am a toast!", Toast.LENGTH_LONG).show()
        }
    }
}