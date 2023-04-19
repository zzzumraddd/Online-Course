package com.example.onlinecourse

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentSignInBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignIn.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignIn : Fragment() {
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
        var binding = FragmentSignInBinding.inflate(inflater, container, false)

        var text = binding.name.toString()
        binding.signin.setOnClickListener {
            val sharedPreference = this.getActivity()?.getSharedPreferences("pref", Context.MODE_PRIVATE)
            val editor = sharedPreference?.edit()
            editor?.putString("mail", text)
            editor?.apply()

            findNavController().navigate(R.id.action_signIn_to_userPage)
        }


        var toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        val activity : AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { findNavController().navigate(R.id.action_signIn_to_createAcc3 )}
        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_signUp)
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignIn().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}