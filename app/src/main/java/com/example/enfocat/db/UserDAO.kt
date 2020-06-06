package com.example.enfocat.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun  deleteUser(user: User)

    @Query("DELETE FROM user_data_table")
    suspend fun  deleteAll()

    @Query("SELECT * FROM user_data_table")
    fun getAllUsers():LiveData<List<User>>
}