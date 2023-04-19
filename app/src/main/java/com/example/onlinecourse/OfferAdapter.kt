package com.example.onlinecourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecourse.databinding.FragmentHomeBinding
import com.example.onlinecourse.databinding.OffersItemBinding

class OfferAdapter(var list: MutableList<OfferItem>) : RecyclerView.Adapter<OfferAdapter.ViewHolder>(){

    class ViewHolder(binding: OffersItemBinding): RecyclerView.ViewHolder(binding.root){
        var description: String = binding.desription.toString()
        var date = binding.date.toString()
        var number = binding.number.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(OffersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.description = list.get(position).decription
        holder.number = list.get(position).number
        holder.date = list.get(position).date
    }

}