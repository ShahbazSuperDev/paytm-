package com.example.demoapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Successfully2: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.successfully)
        val intent = intent
        val text = intent.getStringExtra("money")
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")



        val textView = findViewById<View>(R.id.money) as TextView
        textView.text = text


        val name_Textview = findViewById<View>(R.id.name) as TextView
        name_Textview.text = name

        val number_Textview = findViewById<View>(R.id.number) as TextView
        number_Textview.text = number

        val date_Textview = findViewById<View>(R.id.dateandtime) as TextView
        date_Textview.text = "$date $time"

    }

    }

