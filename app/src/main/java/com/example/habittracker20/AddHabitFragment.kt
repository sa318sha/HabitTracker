package com.example.habittracker20

import Habit
import HabitViewModel
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


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
    // TODO: Rename and change types of parameters


    private lateinit var button: Button
    private lateinit var errorMessage: TextView
    private lateinit var habitName: EditText
    private lateinit var contract: EditText
    private lateinit var viewModel: HabitViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[HabitViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        Log.d("log", "created fragment view")
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add_habit, container, false)

        button = root.findViewById<Button>(R.id.submitHabitButton)
        errorMessage =  root.findViewById<TextView>(R.id.errorHabitMessage)
        habitName = root.findViewById<EditText>(R.id.HabitName)
        contract = root.findViewById<EditText>(R.id.ContractNameResponse)


        button.setOnClickListener{
            Log.d("log", "submitting habit")

            sendHabit(root)
            hideFragment()
        }

        return root

    }

    private fun hideFragment() {
        parentFragmentManager.beginTransaction()
            .setReorderingAllowed(true)

            .replace(R.id.fragmentContainerView, AddButtonFragment.newInstance())
            .commit()
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

    fun clearText(v: View){

        if (v is TextView) {
            val textView = v as TextView
            textView.text = "";
        }
    }
    fun submitHabit(v: View){




    }
    private fun clearHabit(){
        habitName.setText("")
        contract.setText("")
    }
    private fun removeKeyBoard(root: View) {
        val mgr: InputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        mgr.hideSoftInputFromWindow(root.windowToken, 0)
    }
    private fun sendHabit(root: View){
        if (habitName != null && contract != null ) {
            var habitText = habitName.text.toString()
            var contractText = contract.text.toString()

            if(!habitText.equals("")){
                var temp: Habit = Habit(habitText,contractText)
                //valid habit name
                clearHabit()
                removeKeyBoard(root)
                viewModel.changeItem(temp)
            }else{

                if(errorMessage != null){
                    errorMessage.text = "Please Enter Valid Habit Name"
                }
            }
        }
    }



}