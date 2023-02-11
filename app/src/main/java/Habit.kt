object HabitSingleton {
    private var habit: Habit = Habit()

    init {
        habit = Habit()
    }

    fun setHabitValues(_name: String, _contract: String){
        habit.name = _name
        habit.contract = _contract
    }
    fun clearHabitValues(){
        habit.name = ""
        habit.contract = ""
    }
}


class Habit{

    var name: String
    var contract: String

    constructor(name: String = "", contract: String = ""){
        this.name = name
        this.contract = contract
    }


    override fun toString(): String {
        return super.toString()
    }


}
