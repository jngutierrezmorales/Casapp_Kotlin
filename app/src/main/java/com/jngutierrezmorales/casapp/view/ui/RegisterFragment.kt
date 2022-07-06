package com.jngutierrezmorales.casapp.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jngutierrezmorales.casapp.R
import com.jngutierrezmorales.casapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        binding.btnRegisterCreate.setOnClickListener {
            createAccount()
            it.findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
        }

        binding.btnRegisterReturn.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return binding.root
    }

    private fun createAccount() {
        val email = binding.editTextRegisterEmail.text.toString()
        val password = binding.editTextRegisterPassword.text.toString()

        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)

//        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(requireActivity()) { task ->
//            if (task.isSuccessful) {
//                println("Usuario creado")
//            } else {
//                println("Error al crear usuario")
//            }
//        }
    }
}
