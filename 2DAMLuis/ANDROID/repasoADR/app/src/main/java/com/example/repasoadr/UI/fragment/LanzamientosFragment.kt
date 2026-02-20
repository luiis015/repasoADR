package com.example.repasoadr.UI.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.repasoadr.adapter.LaunchAdapter
import com.example.repasoadr.databinding.FragmentLanzamientosBinding
import com.example.repasoadr.databinding.FragmentLoginBinding
import com.example.repasoadr.model.Launch
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

class LanzamientosFragment: Fragment() {
    private lateinit var binding: FragmentLanzamientosBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase




    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://repasoadr-default-rtdb.europe-west1.firebasedatabase.app/")

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLanzamientosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        binding.progresBarLanzamientos
        binding.recyclerViewLanzamientos

        cargarDatos()
    }

    private fun cargarDatos() {
        val gson = Gson()

        val request = JsonArrayRequest(
            "https://api.spacexdata.com/v5/launches",
            {
                for (i in 0 until it.length()) {
                    val obj = gson.fromJson(it.getJSONObject(i).toString(), Launch::class.java)
                    binding.recyclerViewLanzamientos.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = LaunchAdapter(requireContext()).apply {
                            addLaunch(obj)
                        }
                    }

                }
            },
            {

            }
        )

        Volley.newRequestQueue(requireContext()).add(request)
    }





























}

