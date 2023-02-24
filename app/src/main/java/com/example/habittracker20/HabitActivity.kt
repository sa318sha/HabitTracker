package com.example.habittracker20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HabitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit)

        val bundle: Bundle? = intent.extras

        var value: Int = bundle!!.getInt("position")

        Log.d("log", "$value")

    }
}