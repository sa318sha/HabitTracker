package model

import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker20.R


//view class?
class HabitHolder(itemView: View, click: HabitHolderClickOptions) : RecyclerView.ViewHolder(itemView), OnClickListener {
    fun bind(habit: Habit) {

        habitName.text = habit.name
        contract.text = habit.contract
        streak.text = "0"

    }


    var habitName: TextView
    var contract: TextView
    var streak: TextView
    var garbageButton: ImageView
    var checkbox: Button
    var clicking: HabitHolderClickOptions
    init{

        habitName = itemView.findViewById<TextView>(R.id.layoutHabitName)
        contract = itemView.findViewById<TextView>(R.id.layoutContract)
        garbageButton = itemView.findViewById<ImageView>(R.id.GarbageCan)
        checkbox = itemView.findViewById<Button>(R.id.buttonCompleted)
        streak = itemView.findViewById<TextView>(R.id.streak)
        clicking = click


        garbageButton.setOnClickListener(this)
        checkbox.setOnClickListener(this)
        habitName.setOnClickListener(this)
//        checkbox.setOnClickListener(this)

    }




    override fun onClick(v: View) {
        if( v.id == R.id.GarbageCan ){
            if (v is ImageView){
                var temp: ImageView = v
                clicking.garbageCan(temp,adapterPosition)
            }

        }
        else if (v.id == R.id.buttonCompleted){
            if (v is Button){
                var temp: Button = v
                clicking.toggleHabitCompletion((temp))
            }
        }else if (v.id == R.id.layoutHabitName){

            if (v is TextView){
                clicking.habitActivity(v, adapterPosition)
            }
        }

    }


}