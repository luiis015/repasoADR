package com.example.repasoadr.dataset

import com.example.repasoadr.model.Launch

class DataSet {
    companion object {
        val favoritos: ArrayList<Launch> = ArrayList()

        fun addFavorito(launch: Launch) {
            if (favoritos.find { it.id == launch.id } == null) {
                favoritos.add(launch)
            }
        }

        fun clear() {
            favoritos.clear()
        }
    }
}