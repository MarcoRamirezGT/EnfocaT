package com.example.enfocat

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.enfocat.databinding.ListItemBinding
import com.example.enfocat.db.Quizz

class MyRecyclerViewAdapter(private  val quizzes: List<Quizz>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Notz yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(quizz: Quizz){
        binding.nameTextView.text = quizz.name
        binding.descriptionTextView.text = quizz.description
    }
}