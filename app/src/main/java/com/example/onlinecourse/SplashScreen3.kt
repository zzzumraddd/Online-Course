package com.example.onlinecourse

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentSplashScreen3Binding


class SplashScreen3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplashScreen3Binding.inflate(inflater, container, false)

        binding.next2.setOnClickListener {
            findNavController().navigate(R.id.action_splashScreen3_to_splashScreen4)
        }

        return binding.root
    }

}