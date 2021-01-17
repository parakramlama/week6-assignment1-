package com.parakram.week6assignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parakram.week6assignment.DashboardActivity
import com.parakram.week6assignment.R
import com.parakram.week6assignment.adapter.StudentAdapter
import com.parakram.week6assignment.model.StudentModel

class HomeFragments : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerViewUser: RecyclerView
    private var lstUser = arrayListOf<StudentModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val view = inflater.inflate(R.layout.fragments_home, container, false)
        recyclerViewUser = view.findViewById(R.id.recyclerViewUser)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {

            lstUser = (activity as DashboardActivity).lstUser

            val adapter = StudentAdapter(lstUser, view.context)
            recyclerViewUser.layoutManager = LinearLayoutManager(view.context)
            recyclerViewUser.adapter = adapter
        })
        return view
    }
}
