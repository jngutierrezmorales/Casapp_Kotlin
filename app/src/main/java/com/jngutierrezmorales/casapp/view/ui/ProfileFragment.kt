package com.jngutierrezmorales.casapp.view.ui

import android.os.Bundle
import android.os.Handler
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
import com.jngutierrezmorales.casapp.databinding.FragmentProfileBinding
import com.jngutierrezmorales.casapp.repository.FirebaseRepository
import com.jngutierrezmorales.casapp.viewmodel.ProfileViewModel
import com.jngutierrezmorales.casapp.viewmodel.ProfileViewModelFactory
import kotlinx.coroutines.launch

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    private val profileViewModel: ProfileViewModel by viewModels() {
        val repository = FirebaseRepository()
        ProfileViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.btnProfileChangePass.setOnClickListener {
            profileViewModel.viewModelScope.launch {
                profileViewModel.updatePassword(binding.edTxtProfilePass.text.toString())
                Toast.makeText(activity, "Contraseña modificada", Toast.LENGTH_LONG).show()
                it.findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
            }
        }

        binding.btnProfileLogout.setOnClickListener {
            profileViewModel.signOut()
            it.findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }

        return binding.root
    }
}