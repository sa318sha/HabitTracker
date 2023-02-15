import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker20.R

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var image: ImageView
    var habitName: TextView
    var contract: TextView

    init{
        image = itemView.findViewById<ImageView>(R.id.image)
        habitName = itemView.findViewById<TextView>(R.id.layoutHabitName)
        contract = itemView.findViewById<TextView>(R.id.layoutContract)
    }


}