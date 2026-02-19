package com.example.repasoadr.UI.fragment

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.repasoadr.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlin.io.root


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase


    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
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
                        // lo llevamos del inicio del login al inicio del proyecto asi pero adaptado a mi proyecto R.id.action_firstFragment_to_secondFragment
                            var bundle = Bundle()
                            bundle.putString("correo", binding.CorreoDelLogin.text.toString())
                            bundle.putString("pass", binding.ContrasenaDelLogin.text.toString())
                            findNavController().navigate(R.id.fragementLoing_to_inicioFragment, bundle)


                    }else{
                        var bundle = Bundle()
                        bundle.putString("correo", binding.CorreoDelLogin.text.toString())
                        bundle.putString("pass", binding.ContrasenaDelLogin.text.toString())
                        findNavController().navigate(R.id.action_loginFragment_to_inicioDialog, bundle)
                    }
                }
            }
        }
    }
    }


