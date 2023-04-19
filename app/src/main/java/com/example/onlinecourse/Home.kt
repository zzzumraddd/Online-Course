package com.example.onlinecourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.example.onlinecourse.databinding.FragmentHomeBinding
import java.util.Locale


private const val ARG_PARAM1 = "param1"
lateinit var courses : MutableList<Courseitem>
lateinit var courseAdapter: CourseAdapter
lateinit var mutableList: MutableList<Courseitem>


class Home : Fragment(), MenuAdapter.MyClickListener, CourseAdapter.ClickListener {

    private var param1: MutableList<Courseitem>? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as MutableList<Courseitem>

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentHomeBinding.inflate(inflater, container, false)
        var list = mutableListOf<OfferItem>()
        var mentors = mutableListOf<MentorItem>()
        var menues = mutableListOf<String>("Business \uD83D\uDCB0", "UX/UI Design \uD83D\uDCA1", "3D Design", "Mobile")
        courses = mutableListOf<Courseitem>()


        list.add(OfferItem("Get a discount for every course order! Only valid for today", "40%", "Today's Special"))
        list.add(OfferItem("Get a discount for every course order! Only valid for today", "40%", "Today's Special"))
        list.add(OfferItem("Get a discount for every course order! Only valid for today", "40%", "Today's Special"))

        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )
        mentors.add(MentorItem(R.drawable.mentor, "Jacob") )

        courses.add(Courseitem(R.drawable.course, "3D Design Course", "3D Design", false))
        courses.add(Courseitem(R.drawable.business, "Business Course", "Business \uD83D\uDCB0", false))
        courses.add(Courseitem(R.drawable.business, "Design Course", "UX/UI Design \uD83D\uDCA1", false))
        courses.add(Courseitem(R.drawable.course, "Mobile Course", "Mobile", false))



        var offerAdapter = OfferAdapter(list)
        var mentorAdapter = MentorAdapter(mentors)
        var menuAdapter = MenuAdapter(menues, this@Home)
        courseAdapter = CourseAdapter(courses, this@Home)
        binding.offers.setAdapter(offerAdapter)
        binding.mentors.setAdapter(mentorAdapter)
        binding.menues.setAdapter(menuAdapter)
        binding.courses.setAdapter(courseAdapter)

        binding.cardView.setOnClickListener {
            filterList("", courseAdapter)
        }

        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText, courseAdapter)
                return true
            }


        })

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }

    override fun onClick(position: Int) {
        when(position){
            0 ->  filterList2("Business \uD83D\uDCB0", courseAdapter)
            1 ->   filterList2("UX/UI Design \uD83D\uDCA1",courseAdapter)
            2 -> filterList2("3D Design", courseAdapter)
            3 -> filterList2("Mobile", courseAdapter)
        }

    }

    override fun Click(position: Int) {
        findNavController().navigate(R.id.action_userPage_to_coursePage)
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




}