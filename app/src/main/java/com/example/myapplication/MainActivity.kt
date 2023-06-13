package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shui.datepicker.DatePickerDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.test_btn).setOnClickListener {
            DatePickerDialog().show(supportFragmentManager, "TestDatePicker")
        }
    }
}