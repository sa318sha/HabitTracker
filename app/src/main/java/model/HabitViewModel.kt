package model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HabitViewModel: ViewModel() {

    private val mutableSelectedItem = MutableLiveData<Habit>()
    val selectedItem: LiveData<Habit>
        get() =  mutableSelectedItem



    fun changeItem(habit: Habit) {
        mutableSelectedItem.value = habit
    }


}