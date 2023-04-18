package com.example.onlinecourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentSplashScreen4Binding

class SplashScreen4 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplashScreen4Binding.inflate(inflater, container, false)
        binding.next2.setOnClickListener {
         findNavController().navigate(R.id.action_splashScreen4_to_createAcc3)
        }
        return binding.root
    }

}