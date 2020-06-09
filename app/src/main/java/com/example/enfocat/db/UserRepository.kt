package com.example.enfocat.db

class UserRepository(private val dao : QuestionDAO) {
    val users = dao.getAllQuestions()

    suspend fun insert(question: Question){
        dao.insertQuestion(question)
    }

    suspend fun update(question: Question){
        dao.updateQuestion(question)
    }

    suspend fun  delete(question: Question){
        dao.deleteQuestion(question)
    }

    suspend fun  deleteAll(){
        dao.deleteAll()
    }
}