package com.parakram.week6assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parakram.week6assignment.model.StudentModel

class DashboardActivity : AppCompatActivity() {
    val lstUser = arrayListOf<StudentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

        loadUsers()
    }

    private fun loadUsers() {
        lstUser.add(
            StudentModel("Katrina Kaif", 35, "Female", "Mumbai",
            "https://upload.wikimedia.org/wikipedia/commons/8/8b/Katrina_Kaif_promoting_Bharat_in_2019.jpg")
        )
        lstUser.add(StudentModel("Salman Khan", 55, "Male", "Mumbai",
            "https://pbs.twimg.com/profile_images/1268824832424022017/vUx5TGw7.jpg"))
    }
}

