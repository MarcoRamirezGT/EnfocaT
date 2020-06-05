package com.example.enfocat

import android.app.AlarmManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass.
 */
class Alarm1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val v=inflater.inflate(R.layout.fragment_alarm1,fragmentContainer,false)
        val set= v.findViewById<View>(R.id.btn_start_alarm) as Button


            set.setOnClickListener{
            val fragment = RemindFragment()
            val fragmentManager = activity !!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }

}
