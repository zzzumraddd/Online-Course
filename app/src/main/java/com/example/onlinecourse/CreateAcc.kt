package com.example.onlinecourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentCreateAccBinding

class CreateAcc : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCreateAccBinding.inflate(layoutInflater, container, false)
        binding.signin.setOnClickListener {
            findNavController().navigate(R.id.action_createAcc_to_signIn)
        }
        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_createAcc_to_signIn)
        }
        return binding.root
    }

}