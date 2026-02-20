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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
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
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onResume() {
        super.onResume()
        binding.bottomIniciarSesionLogin.setOnClickListener {
            if (binding.CorreoDelLogin.text.isEmpty() || binding.ContrasenaDelLogin.text.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Por favor, complete todos los campos",
                    Snackbar.LENGTH_SHORT
                ).show()
            }else
            {
                auth.signInWithEmailAndPassword(
                    binding.CorreoDelLogin.text.toString(),
                    binding.ContrasenaDelLogin.text.toString()

                ).addOnCompleteListener {
                    if (it.isSuccessful){
                        //si sale bien lo lleva a la pantalla de lanzamientos la forma correcta seria asi :
                        findNavController().navigate(R.id.action_loginFragment_to_lanzamientosFragment)

                    }else{
                        var bundle = Bundle()
                        bundle.putString("correo", binding.CorreoDelLogin.text.toString())
                        bundle.putString("pass", binding.ContrasenaDelLogin.text.toString())
                    }
                }
            }
        }
    }
    /*
     override fun onResume() {
        super.onResume()
        binding.btnIniciarSesion.setOnClickListener {
            if (binding.editCorreo.text.isEmpty() || binding.editContraseA.text.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Por favor, complete todos los campos",
                    Snackbar.LENGTH_SHORT
                ).show()
            }else
            {
                auth.signInWithEmailAndPassword(
                    binding.editCorreo.text.toString(),
                    binding.editContraseA.text.toString()

                ).addOnCompleteListener {
                    if (it.isSuccessful){
                        findNavController().navigate(R.id.action_loginFragment_to_proyectosFragement)

                    }else{
                        var bundle = Bundle()
                        bundle.putString("correo", binding.editCorreo.text.toString())
                        bundle.putString("pass", binding.editContraseA.text.toString())
                        findNavController().navigate(R.id.action_loginFragment_to_inicioDialog, bundle)
                    }
                }
            }
        }
    }
     */
    }


