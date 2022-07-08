package com.jngutierrezmorales.casapp.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jngutierrezmorales.casapp.R
import com.jngutierrezmorales.casapp.databinding.FragmentLoginBinding
import com.jngutierrezmorales.casapp.repository.FirebaseRepository
import com.jngutierrezmorales.casapp.viewmodel.LoginViewModel
import com.jngutierrezmorales.casapp.viewmodel.LoginViewModelFactory
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    private val loginViewModel: LoginViewModel by viewModels {
        val repository = FirebaseRepository()
        LoginViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnLoginToRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLoginToMain.setOnClickListener {
            if (binding.editTextLoginUser.text.isNotEmpty() && editTextLoginPassword.text.isNotEmpty()) {
                loginViewModel.viewModelScope.launch {
                    loginViewModel.signIn(
                        binding.editTextLoginUser.text.toString(),
                        binding.editTextLoginPassword.text.toString()
                    )
                    it.findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                }
            }
        }

        return binding.root
    }
}
