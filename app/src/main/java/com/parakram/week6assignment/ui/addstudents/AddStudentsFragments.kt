package com.parakram.week6assignment.ui.addstudents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.parakram.week6assignment.DashboardActivity
import com.parakram.week6assignment.R
import com.parakram.week6assignment.model.StudentModel

class AddStudentsFragments : Fragment() {

    private lateinit var dashboardViewModel: AddStudentsViewModel

    private lateinit var etFullname: TextInputEditText
    private lateinit var etAge: TextInputEditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers: RadioButton
    private lateinit var etAddress: TextInputEditText
    private lateinit var etProfileLink: TextInputEditText
    private lateinit var btnSave: Button

    private var lstUser = arrayListOf<StudentModel>()
    private var gender: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(AddStudentsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragments_add_students, container, false)

        etFullname = root.findViewById(R.id.etFullname)
        etAge = root.findViewById(R.id.etAge)
        radioGroupGender = root.findViewById(R.id.radioGroupGender)
        rdoMale = root.findViewById(R.id.rdoMale)
        rdoFemale = root.findViewById(R.id.rdoFemale)
        rdoOthers = root.findViewById(R.id.rdoOthers)
        etAddress = root.findViewById(R.id.etAddress)
        etProfileLink = root.findViewById(R.id.etProfileLink)
        btnSave = root.findViewById(R.id.btnSave)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {

            lstUser = (activity as DashboardActivity).lstUser

            radioGroupGender.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    R.id.rdoMale -> {
                        gender = "Male"
                    }
                    R.id.rdoFemale -> {
                        gender = "Female"
                    }
                    R.id.rdoOthers -> {
                        gender = "Others"
                    }
                }
            }

            btnSave.setOnClickListener {
                val fullName = etFullname.text.toString()
                val age = etAge.text.toString().toInt()
                val gen = gender
                val address = etAddress.text.toString()
                val profileLink = etProfileLink.text.toString()

                val user = StudentModel(fullName, age, gen, address, profileLink)
                lstUser.add(user)
                Toast.makeText(context, "added", Toast.LENGTH_SHORT).show()
            }
        })
        return root
    }
}