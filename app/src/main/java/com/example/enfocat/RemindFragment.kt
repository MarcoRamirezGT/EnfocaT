package com.example.enfocat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_remind.*

/**
 * A simple [Fragment] subclass.
 */
class RemindFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vv=inflater.inflate(R.layout.fragment_remind,fragmentContainer,false)
        val btn= vv.findViewById<View>(R.id.btn_alarm1) as Button
        val btn1=vv.findViewById<View>(R.id.btn_alarm) as Button

        val btn2=vv.findViewById<View>(R.id.btn_alarm2) as Button
        val btn3=vv.findViewById<View>(R.id.btn_alarm3) as Button
        val btn4=vv.findViewById<View>(R.id.btn_alarm4) as Button
        val btn5=vv.findViewById<View>(R.id.btn_alarm5) as Button
        val btn6=vv.findViewById<View>(R.id.btn_alarm6) as Button
        val btn7=vv.findViewById<View>(R.id.btn_alarm7) as Button
        val btn8=vv.findViewById<View>(R.id.btn_alarm8) as Button
        val btn9=vv.findViewById<View>(R.id.btn_alarm9) as Button
        val btn10=vv.findViewById<View>(R.id.btn_alarm10) as Button
        val btn11=vv.findViewById<View>(R.id.btn_alarm11) as Button
        val btn12=vv.findViewById<View>(R.id.btn_alarm12) as Button













        btn.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
           startActivity(intent)

        }
        btn1.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn2.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn3.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn4.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn5.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn6.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn7.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn8.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn9.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn10.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn11.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }
        btn12.setOnClickListener{
            val intent = Intent(this@RemindFragment.context,Alarm1_activity::class.java)
            startActivity(intent)

        }



        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


}



