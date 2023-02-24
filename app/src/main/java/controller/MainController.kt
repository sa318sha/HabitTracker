package controller


import HabitStatisticsViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker20.HabitActivity
import com.example.habittracker20.MainActivity
import com.example.habittracker20.R
import model.HabitAdapter
import model.HabitViewModel


class MainController(var A: MainActivity) {
    var mainView : MainActivity = A
    val viewModel: HabitViewModel = ViewModelProvider(mainView)[model.HabitViewModel::class.java]
    val habitRecycler: RecyclerView = A.findViewById<RecyclerView>(R.id.recyclerViewID)
    val habitStatistics: HabitStatisticsViewModel = ViewModelProvider(mainView)[HabitStatisticsViewModel::class.java]
    init{
        habitRecycler.layoutManager = LinearLayoutManager(A)
        habitRecycler.adapter = HabitAdapter(this)



        viewModel.selectedItem.observe(mainView,Observer{
            var idx: Int = habitStatistics.size()
            habitStatistics.add( idx, it)

            (habitRecycler.adapter as HabitAdapter).notifyItemInserted(idx)
        })



    }

    //    private var HabitStatisticsModel
    fun addHabit(name: String, contract: String){

        var allowed: Boolean = habitStatistics.validateHabit(name,contract)
        if (allowed){
            habitStatistics.addHabit(name, contract)
        }else{

        }

    }


    fun updateButton(v: Button){
        if (v.text.equals("Yes")) {
            v.text = "No"
            v.backgroundTintList = mainView.getColorStateList(R.color.lighterred)
        } else {
            v.text = "Yes"
            v.backgroundTintList = mainView.getColorStateList(R.color.lightergreen);
        }
    }

    fun deleteHabitAtIdx(position: Int){
        var validIdx: Boolean = habitStatistics.validIndex(position)
        if(validIdx){
            habitStatistics.removeAt(position)
        }
    }

    fun changeActivity(position: Int) {
        Log.d("log", "Changing activity")
        val myIntent: Intent = Intent(mainView, HabitActivity::class.java)
        val bundle: Bundle = Bundle()
        bundle.putInt("position", position)
        myIntent.putExtras(bundle)
        mainView.startActivity(myIntent)
    }


}