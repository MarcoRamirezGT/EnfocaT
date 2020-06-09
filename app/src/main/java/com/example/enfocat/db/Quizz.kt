package com.example.enfocat.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quizz_data_table")
data class Quizz (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "quizz_id")
    val quizzID: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String){
}