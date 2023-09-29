package com.ivan.week4app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // When You are receiving information from previous activity, you fetch it from the intent
        // You have to assign the value from the extra to a new variable.
        // MAke sure the datatype of your variable match on both activities,
        // using getStringExtra for String data types. or getInteExtra for numbers of type Integer

        var name = intent.getStringExtra("transfering_name")
        var lastName = intent.getStringExtra("transfering_lastName")
        // var age = intent.getIntExtra("age")

        // Once you have received the information from previous activity, you can use it in you screen however you want
        var text1 = findViewById<TextView>(R.id.textView)
        text1.text = "${name} ${lastName}"

    }
}