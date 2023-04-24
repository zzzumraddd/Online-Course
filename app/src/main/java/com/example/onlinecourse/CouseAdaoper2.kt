package com.example.onlinecourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecourse.databinding.CourseitemBinding

class CouseAdaoper2 (var list: MutableList<Courseitem>) : RecyclerView.Adapter<CouseAdaoper2.ViewHolder>(){
    inner class ViewHolder(binding: CourseitemBinding): RecyclerView.ViewHolder(binding.root){
        var image = binding.imageView9
        var name = binding.name
        var type = binding.type
        var fav = binding.fav
        val delete = binding.imageView11
        val card = binding.card

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CourseitemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list.get(position).name
        holder.type.text = list.get(position).type
        holder.image.setImageResource(list.get(position).image)


     holder.delete.setOnClickListener {
           list.remove(list.get(position))
           notifyDataSetChanged()
       }
    }
}