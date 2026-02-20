package com.example.ordinariluisandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ordinariluisandroid.databinding.ItemLanzamientoBinding
import com.example.ordinariluisandroid.model.Launch
class LaunchAdapter(var context: Context): RecyclerView.Adapter<LaunchAdapter.MyHolder>() {
    private  val lista = ArrayList<Launch>()
    inner class MyHolder(var binding: ItemLanzamientoBinding): RecyclerView.ViewHolder(binding.root)


            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
       val  binding = ItemLanzamientoBinding.inflate(
           LayoutInflater.from(context),parent,false
        val binding = ItemLanzamientoBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val launch = lista[position]
        holder.binding.tvTitleLanzamiento.text = launch.Title
        holder.binding.tvNombreLanzamiento.text = launch.body
        holder.binding.tvContnet.text = launch.reactions
       // parra las imagenes serian asi pero no me acuerdo  Glide.with(context).(launch.id).into(holder.binding.ivImagen)

        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }




        TODO("Not yet implemented")
        lista.clear()
        lista.addAll(items)
        notifyDataSetChanged()
    }
}