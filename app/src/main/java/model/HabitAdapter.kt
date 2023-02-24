package model

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.habittracker20.R
import controller.MainController

class HabitAdapter(): RecyclerView.Adapter<HabitHolder>() {
    private lateinit var controller: MainController

    lateinit var habits: List<HabitStatistics>
    lateinit var ctext: Context


    constructor(_controller: MainController) : this() {
        controller = _controller
        habits=controller.habitStatistics.entrees
        ctext=controller.mainView
    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitHolder {
        Log.d("log","created view holder")
        //Log.d("log", "viewType $viewType")

        var v: View = LayoutInflater.from(ctext).inflate(R.layout.habit_view,parent,false)

        return HabitHolder(v,object: HabitHolderClickOptions{
            override fun garbageCan(v: ImageView, adapterPosition: Int) {
                controller.deleteHabitAtIdx(adapterPosition)
                notifyDataSetChanged();
            }
            override fun toggleHabitCompletion(v: Button) {
                controller.updateButton(v)

            }

            override fun habitActivity(v: TextView, adapterPosition: Int) {
                controller.changeActivity(adapterPosition)
            }
        })

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return habits.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: HabitHolder, position: Int) {
        Log.d("log","binded holder")

        holder.bind(habits[position].habit)

    }


}