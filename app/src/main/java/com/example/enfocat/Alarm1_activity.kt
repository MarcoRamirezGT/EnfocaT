package com.example.enfocat

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
import java.util.*

class Alarm1_activity : AppCompatActivity() {

    lateinit var am:AlarmManager
    lateinit var tp: TimePicker
    lateinit var update_text:TextView
    lateinit var con:Context
    lateinit var btnStart: Button
    lateinit var  btnStop: Button
    var hour: Int = 0
    var min : Int = 0
    lateinit var pi: PendingIntent
    lateinit var name: EditText
    private lateinit var saveData: SaveData



    override fun onCreate(savedInstanceState: Bundle?) {

        //Share preference states look
        saveData = SaveData(this)
        if(saveData.loadDarkModeState()==true){
            setTheme(R.style.darkTheme)
        }else
            setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm1_activity)
        this.con = this
        am= getSystemService(Context.ALARM_SERVICE) as AlarmManager
        tp = findViewById(R.id.tp) as TimePicker
        update_text = findViewById(R.id.update_text) as TextView
        btnStart = findViewById(R.id.btn_start_alarm) as Button
        btnStop = findViewById(R.id.btn_stop_alarm) as Button
        var calendar: Calendar = Calendar.getInstance()
        var myIntent: Intent = Intent(this,AlarmReceiver::class.java)
        btnStart.setOnClickListener {
            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
                calendar.set(Calendar.HOUR_OF_DAY,tp.hour)
                calendar.set(Calendar.MINUTE,tp.minute)
                calendar.set(Calendar.SECOND,0)
                calendar.set(Calendar.MILLISECOND,0)
                hour = tp.hour
                min = tp.minute


            } else{
                calendar.set(Calendar.HOUR_OF_DAY,tp.currentHour)
                calendar.set(Calendar.MINUTE,tp.currentMinute)
                calendar.set(Calendar.SECOND,0)
                calendar.set(Calendar.MILLISECOND,0)
                hour = tp.currentHour
                min = tp.currentMinute

            }
            var hr_str:String = hour.toString()
            var min_str: String = min.toString()
            if( hour > 12){
                hr_str=(hour -12).toString()


            }
            if (min <10){
                min_str ="0$min"

            }
            set_alarm_text("Alarm set to: $hr_str:$min_str ")
            myIntent.putExtra("extra","on")
            pi = PendingIntent.getBroadcast(this@Alarm1_activity,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
            am.setExact(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pi)
            name = findViewById<EditText>(R.id.txt_alarm1) as EditText

            val intet = Intent(this,MainActivity::class.java)
            this.startActivity(intet)



        }
        btnStop.setOnClickListener {
            set_alarm_text("Alarm off")
            pi = PendingIntent.getBroadcast(this@Alarm1_activity,0,myIntent,PendingIntent.FLAG_UPDATE_CURRENT)
            am.cancel(pi)
            myIntent.putExtra("extra","off")
            sendBroadcast(myIntent)

        }
    }
    private fun set_alarm_text(s: String){
        update_text.setText(s)
    }

}
