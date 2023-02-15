object HabitSingleton {
    private var referenceCount =0
    var habit: Habit = Habit()

    fun setHabitValues(_name: String, _contract: String){
        referenceCount =0
        habit.name = _name
        habit.contract = _contract
    }



    fun clearHabitValues(){
        habit.name = ""
        habit.contract = ""
    }
}