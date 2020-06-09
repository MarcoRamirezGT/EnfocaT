package com.example.enfocat.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuestionDAO {
    @Insert
    suspend fun insertQuestion(question: Question): Long

    @Update
    suspend fun updateQuestion(question: Question)

    @Delete
    suspend fun  deleteQuestion(question: Question)

    @Query("DELETE FROM question_data_table")
    suspend fun  deleteAll()

    @Query("SELECT * FROM question_data_table")
    fun getAllQuestions():LiveData<List<Question>>
}