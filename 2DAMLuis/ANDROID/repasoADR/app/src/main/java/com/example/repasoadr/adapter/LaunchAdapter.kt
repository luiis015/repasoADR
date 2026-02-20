package com.example.repasoadr.adapter

import android.content.Context


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.repasoadr.databinding.ItemLanzamientoBinding
import com.example.repasoadr.model.Launch
import com.google.firebase.database.FirebaseDatabase

class LaunchAdapter(var context: Context) : RecyclerView.Adapter<LaunchAdapter.MyHolder>() {

    private val lista = ArrayList<Launch>()

    inner class MyHolder(var binding: ItemLanzamientoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemLanzamientoBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val launch = lista[position]

        holder.binding.name.text = launch.name
        holder.binding.details.text = launch.details

        Glide.with(context).load(launch.links?.patch?.small).into(holder.binding.ivImagen)
        /*
                holder.binding.btnFav.setOnClickListener {
                    DataSet.addFavorito(launch)
                }

         */
    }



    override fun getItemCount(): Int = lista.size

    fun addLaunch(l: Launch) {
        lista.add(l)
        notifyItemInserted(lista.size - 1)
    }




    fun clear() {
        lista.clear()
        notifyDataSetChanged()
    }
}