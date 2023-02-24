package model

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

interface HabitHolderClickOptions {
    fun garbageCan(v: ImageView, adapterPosition: Int)
    fun toggleHabitCompletion(v: Button)
    fun habitActivity(v: TextView, position: Int)
}

