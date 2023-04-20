package com.example.onlinecourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinecourse.databinding.CourseitemBinding

class CourseAdapter(var list: MutableList<Courseitem>, val listener: ClickListener) : RecyclerView.Adapter<CourseAdapter.ViewHolder>(){

    private var isFav = false

    var onItemClick : ((Courseitem) -> Unit)? = null
    fun FilteredList(list: MutableList<Courseitem>){
        this.list = list
        notifyDataSetChanged()
    }


    inner class ViewHolder(binding: CourseitemBinding): RecyclerView.ViewHolder(binding.root){
        var image = binding.imageView9
        var name = binding.name
        var type = binding.type
        var fav = binding.fav
        val delete = binding.imageView11
        val card = binding.card



       /* init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                listener.Click()
            }
        }*/

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

        holder.card.setOnClickListener {
            list.get(position).status = true
            listener.Click(list[position])
        }

//        holder.delete.setOnClickListener {
//            list.remove(list.get(position))
//            notifyDataSetChanged()
//        }

    }

    interface ClickListener{
        fun Click(courseitem: Courseitem)
    }
}