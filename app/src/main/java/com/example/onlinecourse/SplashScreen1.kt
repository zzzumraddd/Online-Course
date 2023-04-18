package com.example.onlinecourse

import android.content.Context
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
        val sharedPreference = this.getActivity()?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val name = sharedPreference?.getString("mail","")
        if(name.equals("")) {
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    findNavController().navigate(R.id.action_splashScreen1_to_splashScreen2)
                }, 3000
            )
        }
        else{
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    findNavController().navigate(R.id.action_splashScreen1_to_userPage)
                }, 3000
            )
        }
        val binding = FragmentSplashScreen1Binding.inflate(inflater, container, false)
        return binding.root
    }

}