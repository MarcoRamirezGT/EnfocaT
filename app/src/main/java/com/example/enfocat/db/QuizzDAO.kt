package com.example.enfocat.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuizzDAO {
    @Insert
    suspend fun insertQuizz(quizz: Quizz): Long

    @Update
    suspend fun updateQuizz(quizz: Quizz)

    @Delete
    suspend fun  deleteQuizz(quizz: Quizz)

    @Query("DELETE FROM quizz_data_table")
    suspend fun  deleteAll()

    @Query("SELECT * FROM quizz_data_table")
    fun getAllQuizzes():LiveData<List<Quizz>>
}