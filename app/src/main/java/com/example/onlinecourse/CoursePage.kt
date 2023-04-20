package com.example.onlinecourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinecourse.databinding.FragmentCoursePageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CoursePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class CoursePage : Fragment() {
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
        val binding = FragmentCoursePageBinding.inflate(inflater, container, false)
        parentFragmentManager.beginTransaction().add(R.id.container, About()).commit()
        val courseutem = arguments?.getSerializable("courseItem") as Courseitem

        binding.textView18.text = courseutem.name

        binding.bottomNavigationView2.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.about -> {
                    parentFragmentManager.beginTransaction().replace(R.id.container, About()).commit()
                }
                R.id.lessons ->{
                    parentFragmentManager.beginTransaction().replace(R.id.container,Lessons()).commit()
                }
                R.id.review ->{
                    parentFragmentManager.beginTransaction().replace(R.id.container,Review()).commit()
                }
            }
            true
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
         * @return A new instance of fragment CoursePage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CoursePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}