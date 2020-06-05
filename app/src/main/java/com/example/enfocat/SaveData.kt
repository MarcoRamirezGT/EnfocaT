package com.example.enfocat

import android.content.Context
import android.content.SharedPreferences

class SaveData (context: Context){
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("file", Context.MODE_PRIVATE)


    //This method will save the night Mode state: True or FALSE
    fun setDarkModeState(state: Boolean?){
        val editor = sharedPreferences.edit()

        editor.putBoolean("Dark", state!!)
        editor.apply()

    }
    //This method will load the night mode state
    fun loadDarkModeState():Boolean?{
        val  state = sharedPreferences.getBoolean("Dark",false)
        return (state)


    }
}