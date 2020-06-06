package com.example.enfocat.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val userID: Int,
    @ColumnInfo(name = "user_username")
    val userName: String,
    @ColumnInfo(name = "user_password")
    val password: String){
}