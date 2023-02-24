package com.example.habittracker20

import controller.MainController
//import model.HabitAdapter
//import Model.HabitViewModel
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import controller.AddHabitFragmentController


class MainActivity : AppCompatActivity() {
    private lateinit var habitFragment: AddHabitFragment
    private lateinit var emptyFragment: AddButtonFragment
    private lateinit var controller: MainController
//    private lateinit var viewModel: Model.HabitViewModel
//    private lateinit var habitRecycler: RecyclerView
//    private lateinit var habitList: MutableList<HabitModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("log", "created main activity")

        //inits
        habitFragment = AddHabitFragment.newInstance()
        emptyFragment = AddButtonFragment.newInstance()


        controller = MainController(this)


//        supportFragmentManager.beginTransaction()
//            .setReorderingAllowed(true)
//
//            .add(R.id.fragmentContainerView, emptyFragment)
////
//            .commit()



    }



    fun hideAddHabit(v: View){



        Log.d("log", "Hiding Habit Fragment")


        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .remove(habitFragment)
            .commit()


    }
    fun showAddHabit(v: View){
        Log.d("log", "Displaying Habit Fragment")


        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fragmentContainerView,habitFragment)
            .commit()

    }
}

