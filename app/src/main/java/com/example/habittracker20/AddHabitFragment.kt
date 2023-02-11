package com.example.habittracker20

import HabitSingleton
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.contracts.contract



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
    private var param1: String? = null
    private var param2: String? = nullout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_habit, container, false)
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
        fun newInstance(param1: String, param2: String) =
            AddHabitFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
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
        var habitName = getView()?.findViewById<EditText>(R.id.HabitName)
        var Contract: EditText? = getView()?.findViewById<EditText>(R.id.ContractNameResponse)
        if (habitName != null && Contract != null ) {
            var habittext = habitName.text.toString()
            var contracttext = Contract.text.toString()

            if(!habittext.equals("")){
                //valid habit name
                HabitSingleton.setHabitValues(habittext,contracttext)

            }else{
                var temp = getView()
            }
        }



    }




}