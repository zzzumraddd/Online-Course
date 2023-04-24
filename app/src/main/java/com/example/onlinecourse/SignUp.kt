package com.example.onlinecourse

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentSignUpBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SignUp : Fragment() {
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
        val binding = FragmentSignUpBinding.inflate(inflater, container, false)
        var toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        val activity : AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { findNavController().navigate(R.id.action_signUp_to_createAcc3 )}
        binding.signin.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_signIn)
        }

        var text = binding.name.text.toString()
        binding.signup.setOnClickListener {
            val sharedPreference = this.getActivity()?.getSharedPreferences("pref", Context.MODE_PRIVATE)
            val name = sharedPreference?.getString("mail", "")
            if(!name.equals(text)){
                Toast.makeText(requireContext(),"wrong mail",Toast.LENGTH_SHORT).show()
            }else{
                findNavController().navigate(R.id.action_signUp_to_userPage)
            }
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}