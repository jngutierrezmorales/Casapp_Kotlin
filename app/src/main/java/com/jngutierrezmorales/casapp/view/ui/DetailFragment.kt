package com.jngutierrezmorales.casapp.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.jngutierrezmorales.casapp.R
import com.jngutierrezmorales.casapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //(activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolBarDetail.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_return -> {
                    findNavController().navigate(R.id.action_detailFragment_to_mainFragment)
                    true
                }
                // required official documentation
                else -> false
            }
        }
    }
}