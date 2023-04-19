package com.example.onlinecourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinecourse.databinding.FragmentUserPageBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class UserPage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserPageBinding.inflate(layoutInflater, container, false)
        parentFragmentManager.beginTransaction().add(R.id.container, Home()).commit()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    parentFragmentManager.beginTransaction().replace(R.id.container, Home()).commit()
                }
                R.id.mycourse ->{
                    parentFragmentManager.beginTransaction().replace(R.id.container, MyCourse()).commit()
                }
                R.id.inbox ->{
                    parentFragmentManager.beginTransaction().replace(R.id.container, Inbox()).commit()
                }
                R.id.transaction ->{
                    parentFragmentManager.beginTransaction().replace(R.id.container, Transaction()).commit()
                }
                R.id.profile ->{
                    parentFragmentManager.beginTransaction().replace(R.id.container, Profile()).commit()
                }
            }
        true
            }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserPage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}