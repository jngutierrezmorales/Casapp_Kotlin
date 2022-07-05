package com.jngutierrezmorales.casapp.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jngutierrezmorales.casapp.R
import com.jngutierrezmorales.casapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.btnProfileLogout.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }

        return binding.root
    }
}