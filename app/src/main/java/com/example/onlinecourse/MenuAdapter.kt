package com.example.onlinecourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecourse.databinding.MenuitemBinding

class MenuAdapter(var list: MutableList<String>, val listener: MyClickListener) : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){

    inner class ViewHolder(binding: MenuitemBinding): RecyclerView.ViewHolder(binding.root){
      val name = binding.menuname
        val card = binding.card

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MenuitemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list.get(position)

    }

    interface MyClickListener{
        fun onClick(position: Int)
    }
}