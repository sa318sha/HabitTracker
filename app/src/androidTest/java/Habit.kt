import android.util.Log

object HabitSingleton {



    private fun HabitSingleton() {}



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
