package com.example.repasoadr.UI.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.repasoadr.adapter.LaunchAdapter
import com.example.repasoadr.databinding.FragmentLanzamientosBinding
import com.example.repasoadr.model.Launch
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

class LanzamientosFragment : Fragment() {

    private lateinit var binding: FragmentLanzamientosBinding
    private val adapter by lazy { LaunchAdapter(requireContext()) }
    private val gson = Gson()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        FirebaseAuth.getInstance()
        FirebaseDatabase.getInstance("https://repasoadr-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLanzamientosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerViewLanzamientos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLanzamientos.adapter = adapter
        cargarDatos()
    }

    override fun onResume() {
        super.onResume()
        adapter.clear()
        cargarDatos()
    }

    private fun cargarDatos() {
        val url = "https://api.spacexdata.com/v5/launches"

        Volley.newRequestQueue(requireContext()).add(
            JsonArrayRequest(
                url,
                { arr ->
                    for (i in 0 until arr.length()) {
                        val launch =
                            gson.fromJson(arr.getJSONObject(i).toString(), Launch::class.java)
                        adapter.addLaunch(launch)
                    }
                },
                { err ->
                    Snackbar.make(
                        binding.root, "Error al cargar datos: ${err.message}", Snackbar.LENGTH_LONG).show()

                }
            )
        )
    }
}