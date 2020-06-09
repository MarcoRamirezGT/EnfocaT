package com.example.enfocat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enfocat.db.QuizzRepository
import java.lang.IllegalArgumentException

class QuizzViewModelFactory(private val repository: QuizzRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuizzViewModel::class.java)){
            return QuizzViewModel(repository) as T
        }
        throw IllegalArgumentException("Uknowkn View Model Class")
    }

}