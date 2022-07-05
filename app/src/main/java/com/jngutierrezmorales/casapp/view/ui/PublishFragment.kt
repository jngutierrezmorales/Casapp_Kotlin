package com.jngutierrezmorales.casapp.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.jngutierrezmorales.casapp.R
import com.jngutierrezmorales.casapp.databinding.FragmentPublishBinding

class PublishFragment : Fragment() {

    private lateinit var binding: FragmentPublishBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_publish, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolBarPublish.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_return -> {
                    findNavController().navigate(R.id.action_publishFragment_to_mainFragment)
                    true
                }
                // required official documentation
                else -> false
            }
        }
    }
}