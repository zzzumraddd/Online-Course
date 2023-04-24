package com.example.onlinecourse

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentMyCourseBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Locale

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var course : MutableList<Courseitem>
lateinit var Adapter: CourseAdapter
lateinit var dialog: BottomSheetDialog


class MyCourse : Fragment(), MenuAdapter.MyClickListener {
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
        val binding = FragmentMyCourseBinding.inflate(inflater, container, false)

        var toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        val activity : AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, Home()).commit()
        }

        var menu = mutableListOf<String>("Business \uD83D\uDCB0", "UX/UI Design \uD83D\uDCA1", "3D Design", "Mobile")

        course = mutableListOf<Courseitem>()
        course.add(Courseitem(R.drawable.course, "3D Design Course", "3D Design", false))
        course.add(Courseitem(R.drawable.business, "Business Course", "Business \uD83D\uDCB0", false))
        course.add(Courseitem(R.drawable.business, "Design Course", "UX/UI Design \uD83D\uDCA1", false))
        course.add(Courseitem(R.drawable.course, "Mobile Course", "Mobile", false))
        var menuAdapter = MenuAdapter(menu, this@MyCourse)
        Adapter = CourseAdapter(course, object : CourseAdapter.ClickListener {
            override fun Click(courseitem: Courseitem) {
                val bundle = bundleOf("courseItem" to courseitem)
                findNavController().navigate(R.id.action_userPage_to_coursePage, bundle)
            }

        })
        binding.menues.setAdapter(menuAdapter)
        binding.courses.setAdapter(Adapter)

        binding.cardView.setOnClickListener {
            filterList("", Adapter)
        }

        binding.imageView10.setOnClickListener {
            showBottomSheet()
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyCourse().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun filterList(query: String?, adapter:CourseAdapter){
        if(query != null){
            val filteredList = ArrayList<Courseitem>()
            for(i in courses){
                if(i.name.toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){

            }else{
                adapter.FilteredList(filteredList)
            }
        }
    }

    private fun filterList2(query: String?, adapter: CourseAdapter){
        if(query != null){
            val filteredList = ArrayList<Courseitem>()
            for(i in courses){
                if(i.type.contains(query)){
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){

            }else{
                adapter.FilteredList(filteredList)
            }
        }
    }

    override fun onClick(position: Int) {
        when(position){
            0 ->  filterList2("Business \uD83D\uDCB0", Adapter)
            1 ->   filterList2("UX/UI Design \uD83D\uDCA1", Adapter)
            2 -> filterList2("3D Design", Adapter)
            3 -> filterList2("Mobile", Adapter)
        }
    }

    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.bottom_dialogue, null)
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        val business = dialogView.findViewById<ConstraintLayout>(R.id.business)
        val design = dialogView.findViewById<ConstraintLayout>(R.id.design)
        val mobile =dialogView.findViewById<ConstraintLayout>(R.id.mobile)
        val all =dialogView.findViewById<ConstraintLayout>(R.id.all)
        business.setOnClickListener {
            filterList2("Business \uD83D\uDCB0", Adapter)
            business.setBackgroundColor(Color.BLUE)
            mobile.setBackgroundColor(Color.WHITE)
            all.setBackgroundColor(Color.WHITE)
            design.setBackgroundColor(Color.WHITE)

        }

        design.setOnClickListener {
            filterList2("UX/UI Design \uD83D\uDCA1", Adapter)
            design.setBackgroundColor(Color.BLUE)
            mobile.setBackgroundColor(Color.WHITE)
            all.setBackgroundColor(Color.WHITE)
            business.setBackgroundColor(Color.WHITE)
        }

        mobile.setOnClickListener {
            filterList2("Mobile", Adapter)
            mobile.setBackgroundColor(Color.BLUE)
            business.setBackgroundColor(Color.WHITE)
            all.setBackgroundColor(Color.WHITE)
            design.setBackgroundColor(Color.WHITE)
        }

        all.setOnClickListener {
            filterList("", Adapter)
            all.setBackgroundColor(Color.BLUE)
            mobile.setBackgroundColor(Color.WHITE)
            business.setBackgroundColor(Color.WHITE)
            design.setBackgroundColor(Color.WHITE)
        }

        dialog.show()
    }


}