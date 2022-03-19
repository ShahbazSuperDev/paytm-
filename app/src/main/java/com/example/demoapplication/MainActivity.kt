package com.example.demoapplication

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.narcos)

        val button: Button = findViewById<View>(R.id.btn_login) as Button
        val show: ImageView = findViewById<View>(R.id.iv_show) as ImageView
        val hide: ImageView = findViewById<View>(R.id.iv_hide) as ImageView
        val etPass: EditText = findViewById<View>(R.id.etPass) as EditText
        button.setOnClickListener {
            Toast.makeText(this@MainActivity, "login successfull.", Toast.LENGTH_SHORT).show()
        }
        show.setOnClickListener {
            hide.visibility = View.VISIBLE
            show.visibility = View.INVISIBLE
            etPass.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        }
        hide.setOnClickListener {
            hide.visibility = View.INVISIBLE
            show.visibility = View.VISIBLE
            etPass.setInputType(InputType.TYPE_CLASS_TEXT);

        }

    }

}




