package com.jngutierrezmorales.casapp.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jngutierrezmorales.casapp.view.ui.FavoriteFragment
import com.jngutierrezmorales.casapp.view.ui.HomeFragment
import com.jngutierrezmorales.casapp.view.ui.MainFragment
import com.jngutierrezmorales.casapp.view.ui.ProfileFragment
import com.jngutierrezmorales.casapp.databinding.FragmentMainBinding

class TabPageAdapter(fragment: MainFragment, private val tabCount: Int) : FragmentStateAdapter(fragment) {

    private lateinit var binding: FragmentMainBinding

    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> FavoriteFragment()
            2 -> ProfileFragment()
            else -> HomeFragment()
        }
    }
}