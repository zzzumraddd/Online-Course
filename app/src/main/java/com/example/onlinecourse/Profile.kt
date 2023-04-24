package com.example.onlinecourse

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentProfileBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile : Fragment() {
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
        val binding = FragmentProfileBinding.inflate(layoutInflater, container,false)

        var toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        val activity : AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, Home()).commit()
        }
        val sharedPreference = this.getActivity()?.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val name = sharedPreference?.getString("mail","").toString()

        binding.name.setText(name)

        binding.button.setOnClickListener {
             MaterialAlertDialogBuilder(requireContext()).setTitle("Alert").setMessage("Do you want to delete your account?").setPositiveButton("Yes"
             ) { p0, p1 ->
                 val editor = sharedPreference?.edit()
                 editor?.putString("mail", "")
                 editor?.apply()
                 findNavController().navigate(R.id.action_userPage_to_splashScreen1)
             }
                 .setNegativeButton("No", object : DialogInterface.OnClickListener {
                     override fun onClick(p0: DialogInterface?, p1: Int) {
                         Toast.makeText(requireContext(), "You don't log out", Toast.LENGTH_SHORT).show()
                     }
                 })
                 .show()

        }
        binding.button2.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext()).setTitle("Alert").setMessage("Do you want to delete your account?").setPositiveButton("Yes"
            ) { p0, p1 ->
                findNavController().navigate(R.id.action_userPage_to_splashScreen1)
            }
                .setNegativeButton("No", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(requireContext(), "Your account will not be deleted", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()

        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}