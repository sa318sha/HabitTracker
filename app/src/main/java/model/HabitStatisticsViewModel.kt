import androidx.lifecycle.ViewModel
import model.Habit
import model.HabitStatistics

class HabitStatisticsViewModel: ViewModel(){

    //future mysql table LOL

//    val entrees: MutableMap<String, HabitStatistics> = mutableMapOf<String, HabitStatistics>()
    private var _entrees: MutableList<HabitStatistics> = mutableListOf<HabitStatistics>()

    val entrees: List<HabitStatistics>
        get() = _entrees



    fun addHabit(name: String, contract: String) {
        val temp = Habit(name,contract)
        _entrees.add(HabitStatistics(temp))
    }

    fun validateHabit(name: String, contract: String): Boolean {
        for ( i in entrees){
            if (i.habit.name.equals(name)){
                return false
            }
        }
        return true
    }

    fun validIndex(idx: Int): Boolean{
        if(idx > 0 && idx < entrees.size){
            return true
        }
        return false
    }
    fun size(): Int {
        return entrees.size
    }

    fun add(idx: Int, it: Habit) {
        _entrees.add(idx, HabitStatistics(it))
    }

    fun removeAt(idx: Int) {
        _entrees.removeAt(idx)
    }


}
