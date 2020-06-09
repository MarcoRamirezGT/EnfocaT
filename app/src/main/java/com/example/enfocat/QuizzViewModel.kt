package com.example.enfocat

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enfocat.db.Quizz
import com.example.enfocat.db.QuizzRepository
import kotlinx.coroutines.launch

class QuizzViewModel(private val repository: QuizzRepository) : ViewModel(), Observable {
    val quizzes = repository.quizzes
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    @Bindable
    val inputQuizzName = MutableLiveData<String>()
    @Bindable
    val inputQuizzDescription = MutableLiveData<String>()
    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()
    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    fun saveOrUpdate(){
        val name = inputQuizzName.value!!
        val description = inputQuizzDescription.value!!
        insert(Quizz(0,name,description))
        inputQuizzName.value = null
        inputQuizzDescription.value = null
    }

    fun clearAllOrDelete(){
        clearAll()
    }

    fun insert(quizz: Quizz)= viewModelScope.launch {
        repository.insert(quizz)
    }

    fun update(quizz: Quizz)= viewModelScope.launch {
        repository.update(quizz)
    }

    fun delete(quizz: Quizz)= viewModelScope.launch {
        repository.delete(quizz)
    }

    fun clearAll()= viewModelScope.launch {
        repository.deleteAll()
    }
}