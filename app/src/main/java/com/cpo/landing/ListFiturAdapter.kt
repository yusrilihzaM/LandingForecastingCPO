package com.cpo.landing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cpo.landing.databinding.ItemFiturBinding

class ListFiturAdapter(private val listMenu: ArrayList<Fitur>): RecyclerView.Adapter<ListFiturAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding: ItemFiturBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(fitur: Fitur){
            with(binding){
                Glide.with(itemView.context)
                    .load(fitur.ic)
                    .into(photo)
                title.text = fitur.title

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding=ItemFiturBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMenu[position])
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}