package com.example.demoapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.superman)

        supportActionBar?.hide()

        Handler().postDelayed(Runnable {val intent=Intent(this,home::class.java)
                                       startActivity(intent)
                                       finish()

                                       },

            3000)
    }
}