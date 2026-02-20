package com.example.ordinariluisandroid.UI.fragment

import androidx.fragment.app.Fragment
import com.example.ordinariluisandroid.adapter.LaunchAdapter
import com.example.ordinariluisandroid.databinding.FragmentLanzamientosBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.ValueEventListener


class LanzamientosFragment: Fragment() {
    private lateinit var database: FirebaseDatabase
    private lateinit var binding: FragmentLanzamientosBinding
    private lateinit var adapter: LaunchAdapter
    private val gson = Gson()


    override fun onAttach(context: Context) {
        super.onAttach(context)
    private val adapter by lazy {
        LaunchAdapter(requireContext())
    }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        database = FirebaseDatabase.getInstance()
    ): View {
        binding = FragmentLanzamientosBinding.inflate(inflater, container, false)
        return binding.root
    }
    // con base de datos:
    override fun onResume(context: Context) {
        super.onAttach(context)
        database =
            FirebaseDatabase.getInstance("https://ordinarialuisandroid-default-rtdb.europe-west1.firebasedatabase.app/")
        for (i in 0 until 10) {
            // Navegar al fragment de detalle pasando el objeto Launch
            val bundle = Bundle().apply {
                putSerializable("launch", launch)
            }
            findNavController().navigate(R.id.action_lanzamientosFragment_to_detalleFragment, bundle)
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = adapter

        // Primero intentar cargar desde Firebase "data"
        cargarDatosDesdeFirebase()
    }

        cargarDatos()
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
// desde json
    private fun cargarDatos() {
                url,
                { arr ->
                    for (i in 0 until < arr . length ()) {
                        val launch =
                            gson.fromJson(arr.getJSONObject(i).toString(), Launch::class.java)
                        adapter.lista.add(launch)

                    }

                },
                {
                    Snackbar.make(binding.root, "Error al cargar los datos", Snackbar.LENGTH_LONG)
                        .show()
                }

            )
        )
    }


                null,
                { response ->
                    binding.progressBar.visibility = View.GONE
                    try {
                        val postsArray = response.getJSONArray("posts")
                        val launches = ArrayList<Launch>()

                        for (i in 0 until postsArray.length()) {
                            val postObj = postsArray.getJSONObject(i)

                            // Parsear los tags del JSON
                            val tagsArray = postObj.optJSONArray("tags")
                            val tags = ArrayList<String>()
                            if (tagsArray != null) {
                                for (j in 0 until tagsArray.length()) {
                                    tags.add(tagsArray.getString(j))
                                }
                            }

                            val launch = Launch(
                                id = postObj.optInt("id"),
                                title = postObj.optString("title"),
                                tags = tags,
                                reactions = postObj.optInt("reactions")
                            )
                        }

                        // Guardar los datos en Firebase bajo el nodo "data"
                        for (launch in launches) {
                            database.reference.child("data").child(launch.id.toString()).setValue(launch)
                        }

                        adapter.addAll(launches)

                    } catch (e: Exception) {
                        Snackbar.make(binding.root, "Error al parsear los datos", Snackbar.LENGTH_LONG).show()
                    }
                },
                { error ->
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.root, "Error al cargar los datos: ${error.message}", Snackbar.LENGTH_LONG).show()
                }
            )
        )
    }
}
