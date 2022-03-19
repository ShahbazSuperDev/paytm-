package com.example.demoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successfully);

        Intent intent = getIntent();
        String text = intent.getStringExtra("money");
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");




        TextView textView = (TextView) findViewById(R.id.money);
        textView.setText(text);


        TextView name_Textview = (TextView) findViewById(R.id.name);
        name_Textview.setText(name);

        TextView number_Textview = (TextView) findViewById(R.id.number);
        number_Textview.setText(number);

        TextView date_Textview = (TextView) findViewById(R.id.dateandtime);
        date_Textview.setText(date + " "+time);


    }
}



