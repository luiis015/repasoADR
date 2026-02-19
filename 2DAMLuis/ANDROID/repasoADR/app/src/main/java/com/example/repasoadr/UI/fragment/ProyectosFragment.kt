package com.example.repasoadr.UI.fragment



import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONArray

class ProyectosFragment: Fragment() {
    private  lateinit var binding: FragmentProyectosBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var adapterProyectos: ProyectosAdapter
    private val url = "https://api.spacexdata.com/v5/launches"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        adapterProyectos = ProyectosAdapter(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProyectosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        datosJson(url)
        binding.recyclerViewProyectos.adapter = adapterProyectos
        binding.recyclerViewProyectos.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapterProyectos.addProyects(        DataSet.listaPrueba.get(0))
        adapterProyectos.addProyects(   DataSet.listaPrueba.get(1))
    }

    private fun datosJson(url: String){

        val petiJson = JsonObjectRequest(
            url,
            {
                val gson = Gson()
                val proyectArray: JSONArray = it.getJSONArray("")

                for (i in 0..proyectArray.length()-1){
                    val proyectJson = proyectArray.getJSONObject(i)
                    val proyect = gson.fromJson(proyectJson.toString(), Proyects::class.java)
                    adapterProyectos.addProyects(proyect)
                }




            },{
                Snackbar.make(binding.root,
                    "Error al cargar los datos", Snackbar.LENGTH_SHORT).show()
            })
        Volley.newRequestQueue(this.context).add(petiJson)


    }
}