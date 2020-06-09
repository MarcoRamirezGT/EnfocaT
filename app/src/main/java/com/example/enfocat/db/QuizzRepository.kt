package com.example.enfocat.db

class QuizzRepository(private val dao : QuizzDAO) {
    val quizzes = dao.getAllQuizzes()

    suspend fun insert(quizz: Quizz){
        dao.insertQuizz(quizz)
    }

    suspend fun update(quizz: Quizz){
        dao.updateQuizz(quizz)
    }

    suspend fun  delete(quizz: Quizz){
        dao.deleteQuizz(quizz)
    }

    suspend fun  deleteAll(){
        dao.deleteAll()
    }
}