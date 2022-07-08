package com.jngutierrezmorales.casapp.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jngutierrezmorales.casapp.R
import com.jngutierrezmorales.casapp.databinding.FragmentRegisterBinding
import com.jngutierrezmorales.casapp.repository.FirebaseRepository
import com.jngutierrezmorales.casapp.viewmodel.RegisterViewModel
import com.jngutierrezmorales.casapp.viewmodel.RegisterViewModelFactory
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.coroutines.*
import org.jetbrains.annotations.TestOnly

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var

    private val registerViewModel: RegisterViewModel by viewModels {
        val repository = FirebaseRepository()
        RegisterViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        binding.btnRegisterCreate.setOnClickListener {
            if (binding.editTextRegisterEmail.text.isNotEmpty() && editTextRegisterPassword.text.isNotEmpty()) {
                registerViewModel.viewModelScope.launch {
                    registerViewModel.createAccount(
                        binding.editTextRegisterEmail.text.toString(),
                        binding.editTextRegisterPassword.text.toString()
                    )
                    Toast.makeText(activity, "Usuario creado", Toast.LENGTH_LONG).show()
                    it.findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
                }
            }
        }

        binding.btnRegisterReturn.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        return binding.root
    }
}
