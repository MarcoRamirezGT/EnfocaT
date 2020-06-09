package com.example.enfocat

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.enfocat.databinding.FragmentQuizzBinding
import com.example.enfocat.db.EnfocaTDatabase
import com.example.enfocat.db.QuizzRepository

/**
 * A simple [Fragment] subclass.
 */
class QuizzFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quizz, container, false)
    }
}

class QuizzActivity : AppCompatActivity(){
    private lateinit var binding: FragmentQuizzBinding
    private  lateinit var quizzViewModel: QuizzViewModel
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        //binding = DataBindingUtil.setContentView(this,R.layout.fragment_quizz)
        val dao = EnfocaTDatabase.getInstance(application).quizzDAO
        val repository = QuizzRepository(dao)
        val factory = QuizzViewModelFactory(repository)
        quizzViewModel = ViewModelProvider(this, factory).get(QuizzViewModel::class.java)
        binding.myViewModel = quizzViewModel
        binding.lifecycleOwner = this
        displayQuizzesList()

    }

    private fun displayQuizzesList(){
        quizzViewModel.quizzes.observe(this, Observer {
            Log.i("MYTAG",it.toString())
        })
    }
}
