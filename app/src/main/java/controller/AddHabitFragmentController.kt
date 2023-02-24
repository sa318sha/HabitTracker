package controller

import model.Habit
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import com.example.habittracker20.AddHabitFragment
import model.HabitViewModel

class AddHabitFragmentController(var A: AddHabitFragment) {
    private var addHabit : AddHabitFragment = A
    private val viewModel: HabitViewModel = ViewModelProvider(addHabit.requireActivity())[model.HabitViewModel::class.java]


    fun clearHabit(){
        addHabit.habitName.setText("")
        addHabit.contract.setText("")
        addHabit.errorMessage.text = "Please Enter Valid Habit Name"
    }
    fun submitHabit(v: View) {
        if (addHabit.habitName != null && addHabit.contract != null ) {
            var habitText = addHabit.habitName.text.toString()
            var contractText = addHabit.contract.text.toString()

            if(habitText != ""){
                var temp: Habit = Habit(habitText,contractText)
                //valid habit name
                clearHabit()
                removeKeyBoard(v)

                viewModel.changeItem(temp)
            }else{

                if(addHabit.errorMessage != null){
                    addHabit.errorMessage.text = "Please Enter Valid Habit Name"
                }
            }
        }

    }
    private fun removeKeyBoard(root: View) {
        val mgr: InputMethodManager = addHabit.requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        mgr.hideSoftInputFromWindow(root.windowToken, 0)
    }


}