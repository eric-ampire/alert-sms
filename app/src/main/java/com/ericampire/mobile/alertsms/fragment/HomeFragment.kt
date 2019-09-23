package com.ericampire.mobile.alertsms.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment

import com.ericampire.mobile.alertsms.R
import com.ericampire.mobile.alertsms.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val navController by lazy {
        NavHostFragment.findNavController(this)
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, state: Bundle?): View? {
        val binding = FragmentHomeBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        binding.textView.setOnClickListener {
            val action = HomeFragmentDirections.actionSetting()
            navController.navigate(action)
        }

        return binding.root
    }
}
