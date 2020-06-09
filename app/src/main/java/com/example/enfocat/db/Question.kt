package com.example.enfocat.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_data_table")
data class Question (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "answer_id")
    val userID: Int,
    @ColumnInfo(name = "question")
    val userName: String,
    @ColumnInfo(name = "answer")
    val password: String){
}