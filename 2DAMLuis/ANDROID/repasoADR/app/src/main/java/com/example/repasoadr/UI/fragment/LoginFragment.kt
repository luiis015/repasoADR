package com.example.repasoadr.UI.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.repasoadr.R
import com.example.repasoadr.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var database: FirebaseDatabase


    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase.getInstance("https://repasoadr-default-rtdb.europe-west1.firebasedatabase.app/")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onResume() {
        super.onResume()
        binding.bottomIniciarSesionLogin.setOnClickListener {
            val correo = binding.CorreoDelLogin.text.toString().trim()
            val pass = binding.ContrasenaDelLogin.text.toString().trim()

            if (correo.isEmpty() || pass.isEmpty()) {
                Snackbar.make(binding.root, "Por favor, complete todos los campos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val loginMap = hashMapOf<String, Any>(
                "correo" to correo,
                "timestamp" to System.currentTimeMillis()
            )

            database.reference.child("logins").push().setValue(loginMap)




            findNavController().navigate(R.id.action_loginFragment_to_lanzamientosFragment)
        }
    }
}