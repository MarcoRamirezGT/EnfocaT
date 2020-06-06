package com.example.enfocat.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class EnfocaTDatabase : RoomDatabase(){
    abstract  val userDAO: UserDAO

    companion object{
        @Volatile
        private  var INSTANCE : EnfocaTDatabase? = null
            fun getInstance(context: Context):EnfocaTDatabase{
                synchronized(this){
                    var instance = INSTANCE
                        if(instance==null){
                            instance = Room.databaseBuilder(
                                context.applicationContext,
                                EnfocaTDatabase::class.java,
                                "user_data_database"
                            ).build()
                        }
                    return instance
                }
            }
    }

}