package com.example.onlinecourse

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentSplashScreen1Binding



class SplashScreen1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler(Looper.getMainLooper()).postDelayed(
            {findNavController().navigate(R.id.action_splashScreen1_to_splashScreen2)}, 3000
        )
        val binding = FragmentSplashScreen1Binding.inflate(inflater, container, false)
        return binding.root
    }

}