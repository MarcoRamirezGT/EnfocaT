package com.example.enfocat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch

class settings : AppCompatActivity() {

    private var switch: Switch?=null
    private lateinit var saveData: SaveData

    override fun onCreate(savedInstanceState: Bundle?) {

        //Share preference states look
        saveData = SaveData(this)
        if(saveData.loadDarkModeState()==true){
            setTheme(R.style.darkTheme)
        }else
            setTheme(R.style.AppTheme)



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        switch = findViewById<View>(R.id.On_Off) as Switch?
        if(saveData.loadDarkModeState() == true){
            switch!!.isChecked = true

        }
        //On click ON_OFF
        switch!!.setOnCheckedChangeListener{_,isChecked->
            if(isChecked){
                saveData.setDarkModeState(true)
                restartApplication()

            }else{
                saveData.setDarkModeState(false)
                restartApplication()
            }
        }

        //Button to jump second activity
        val button = findViewById<Button>(R.id.Jump)
        button .setOnClickListener{
            val intent = Intent(this@settings,MainActivity::class.java)
            startActivity(intent)
        }



    }
    //restart application on click ON_OFF
    private fun restartApplication(){
        val i = Intent(applicationContext,settings::class.java)
        startActivity(i)
        finish()

    }
}
