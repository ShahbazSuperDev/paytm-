package com.example.demoapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import java.util.*
import android.widget.TimePicker
import java.time.LocalDate
import kotlin.concurrent.timer


class home : AppCompatActivity() {

    // Initialise the DrawerLayout, NavigationView and ToggleBar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("WrongConstant", "NewApi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.paytm)

        val title: TextView = findViewById<View>(R.id.toolbar) as TextView
        val right: ImageView = findViewById<View>(R.id.right) as ImageView
        val book: EditText = findViewById<View>(R.id.phone_book) as EditText
        val submit: Button = findViewById<View>(R.id.submit) as Button
        val set: Button = findViewById<View>(R.id.setting) as Button
        val contact: EditText = findViewById<View>(R.id.contact_list) as EditText
        val amount_show: EditText = findViewById<View>(R.id.amount_show) as EditText
        val time_show: EditText = findViewById<View>(R.id.time_show) as EditText
        val calendar: EditText = findViewById<View>(R.id.calendar) as EditText






        title.setText("spoof paytm")
        book.setOnClickListener {
            Toast.makeText(this@home, "open.", Toast.LENGTH_SHORT).show()
        }
        submit.setOnClickListener {
            var intent = Intent(this, MyActivity::class.java)
            intent.putExtra("name", book.text.toString())
            intent.putExtra("number", contact.text.toString())
            intent.putExtra("money", amount_show.text.toString())
            intent.putExtra("time", time_show.text.toString())
            intent.putExtra("date", calendar.text.toString())



            startActivity(intent)
        }
        set.setOnClickListener {
            Toast.makeText(this@home, "open setting.", Toast.LENGTH_SHORT).show()
        }
        calendar.setOnClickListener(View.OnClickListener {

            val mYear = 2022
            val mMonth = 0
            val mDay = 25
            var cal = Calendar.getInstance()

            var datePickerDialog = DatePickerDialog(
                this@home,
                { view, year, monthOfYear, dayOfMonth -> // set day of month , month and year value in the edit text
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    
                    val myFormat = "dd/MM/yyyy" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    calendar.setText((sdf.format(cal.time)))
                }, mYear, mMonth, mDay

            )
            datePickerDialog.show()

        });
        time_show.setOnClickListener(View.OnClickListener {
            val myFormat = "HH:MM" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            time_show.setText((sdf.format(time_show.drawingTime)))
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
            val minute = mcurrentTime[Calendar.MINUTE]
            val mTimePicker: TimePickerDialog
            mTimePicker = TimePickerDialog(this@home,
                { timePicker, selectedHour, selectedMinute -> time_show.setText("$selectedHour:$selectedMinute") },
                hour,
                minute,
                true
            ) //Yes 24 hour time

            mTimePicker.setTitle("Select Time")
            mTimePicker.show()

        })


        // Call findViewById on
        // the DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)


        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerLayout.closeDrawer(Gravity.END)
        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarToggle.syncState()
        right.setOnClickListener {
            drawerLayout.openDrawer(Gravity.END)
        }

        // Call findViewById on the NavigationView
        navView = findViewById(R.id.nav_view)

        // Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked
        navView.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawers()
            when (menuItem.itemId) {
                R.id.phone_book -> {
                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
                    true

                }
                /*   R.id.people -> {
                       Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                       true
                   }
                   R.id.settings -> {
                       Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                       true
                   }*/
                else -> {
                    false
                }

            }
        }
    }


    // override the onSupportNavigateUp() function to launch the Drawer when the hamburger icon is clicked
    @SuppressLint("WrongConstant")
    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navView)

        return true

    }

}
