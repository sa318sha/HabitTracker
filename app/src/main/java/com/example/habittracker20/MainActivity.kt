package com.example.habittracker20

import Habit
import HabitAdapter
import HabitViewModel
import android.database.Observable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var habitFragment: AddHabitFragment
    private lateinit var emptyFragment: AddButtonFragment
    private lateinit var viewModel: HabitViewModel
    private lateinit var habitRecycler: RecyclerView
    private lateinit var habitList: MutableList<Habit>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("log", "created main activity")

        //inits
        habitFragment = AddHabitFragment.newInstance()
        emptyFragment = AddButtonFragment.newInstance()

        viewModel = ViewModelProvider(this)[HabitViewModel::class.java]


        habitList = mutableListOf<Habit>()


        habitRecycler= findViewById<RecyclerView>(R.id.recyclerViewID)
        habitRecycler.layoutManager = LinearLayoutManager(this)

        habitRecycler.adapter = HabitAdapter(application,habitList)


        viewModel.SelectedItem.observe(this, Observer{
            Log.d("log", it.name)
            var idx: Int = habitList.size
            habitList.add(idx, it)
            (habitRecycler.adapter as HabitAdapter).notifyItemInserted(idx)
        })






        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)

            .replace(R.id.fragmentContainerView, emptyFragment)
            .commit()

    }



    fun hideAddHabit(v: View){



        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)

            .replace(R.id.fragmentContainerView, emptyFragment)
            .commit()


    }
    fun showAddHabit(v: View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainerView, habitFragment)
            .commit()
    }
}

