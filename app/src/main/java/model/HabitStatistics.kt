package model

import java.util.*



data class HabitStatistics(var h: Habit) {

    var habit: Habit = h
    var longestStreak: Int = 0
    var currentStreak: Int =0
    lateinit var startDate: Date
    lateinit var DaysCompleted: Vector<Int>
    lateinit var lastCompletedDate: Date


    init{
        startDate = Calendar.getInstance().time
        longestStreak = 0
        currentStreak = 0

    }




}




