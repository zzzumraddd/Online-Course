package com.example.onlinecourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecourse.databinding.MentoritemBinding
import com.example.onlinecourse.databinding.OffersItemBinding

class MentorAdapter(var list: MutableList<MentorItem>) : RecyclerView.Adapter<MentorAdapter.ViewHolder>() {

    class ViewHolder(binding: MentoritemBinding): RecyclerView.ViewHolder(binding.root){
       var image = binding.imageView8
        var name = binding.textView13
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MentoritemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list.get(position).name
        holder.image.setImageResource(list.get(position).image)
    }
}