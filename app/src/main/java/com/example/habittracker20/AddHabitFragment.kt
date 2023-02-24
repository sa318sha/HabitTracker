package com.example.habittracker20

//import controller.AddHabitFragmentController
//import Model.HabitViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import controller.AddHabitFragmentController


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddHabitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddHabitFragment : Fragment() {

    lateinit var button: Button
    lateinit var errorMessage: TextView
    lateinit var habitName: EditText
    lateinit var contract: EditText
    lateinit var fragmentController: AddHabitFragmentController
//    private lateinit var viewModel: Model.HabitViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentController = AddHabitFragmentController(this)
//        viewModel = ViewModelProvider(requireActivity())[Model.HabitViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add_habit, container, false)

        button = root.findViewById<Button>(R.id.submitHabitButton)
        errorMessage =  root.findViewById<TextView>(R.id.errorHabitMessage)
        habitName = root.findViewById<EditText>(R.id.HabitName)
        contract = root.findViewById<EditText>(R.id.ContractNameResponse)


        button.setOnClickListener{
            Log.d("log", "submitting habit")
            fragmentController.submitHabit(root)




            parentFragmentManager.beginTransaction()
                .setReorderingAllowed(true)

                .remove(this)
                .commit()
        }

        return root

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddHabitFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            AddHabitFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }


    override fun onResume() {
        super.onResume()
        Log.d("log", "fragment resumed")

    }

}