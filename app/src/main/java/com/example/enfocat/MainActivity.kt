package com.example.enfocat

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var saveData: SaveData


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId){
            R.id.home->{
            println("Home Pressed")
                replaceFragment(HomeFragment())
            return@OnNavigationItemSelectedListener  true

        }
            R.id.remind->{
                println("Remind Pressed")
                replaceFragment(RemindFragment())
                return@OnNavigationItemSelectedListener  true

            }
            R.id.search->{
                println("Search Pressed")
                replaceFragment(QuizzFragment())
                return@OnNavigationItemSelectedListener  true

            }
            R.id.profile->{
                println("Profile Pressed")
                replaceFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener  true

            }
        }
        false

    }





    override fun onCreate(savedInstanceState: Bundle?) {
        //Share preference states look
        saveData = SaveData(this)
        if(saveData.loadDarkModeState()==true){
            setTheme(R.style.darkTheme)
        }else
            setTheme(R.style.AppTheme)



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }



}
