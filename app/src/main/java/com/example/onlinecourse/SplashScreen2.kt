package com.example.onlinecourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentSplashScreen2Binding


class SplashScreen2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplashScreen2Binding.inflate(inflater, container, false)


        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_splashScreen2_to_splashScreen3)
        }

        return binding.root
    }

}