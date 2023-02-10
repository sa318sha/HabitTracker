package com.example.habittracker20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a:View = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        a.visibility = View.INVISIBLE;
        var v:View = findViewById<FragmentContainerView>(R.id.floatingActionButton)
        v.visibility = View.VISIBLE;
    }



    fun hideAddHabit(v: View){
        var a:View = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        a.visibility = View.INVISIBLE
        var btn:View = findViewById<FragmentContainerView>(R.id.floatingActionButton)
        btn.visibility = View.VISIBLE;
    }
    fun showAddHabit(v: View){
        var a:View = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        a.visibility = View.VISIBLE;
        v.visibility = View.INVISIBLE
    }
}