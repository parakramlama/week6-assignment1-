package com.parakram.week6assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var etUserName: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUserName = findViewById(R.id.etUserName)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()

            if(userName == "softwarica" && password == "coventry") {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show()
                etUserName.error = "Username or password is incorrect"
                etUserName.requestFocus()
            }
        }
    }

    private fun validate(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etUserName.text) -> {
                etUserName.error = "Username or password is incorrect"
                etUserName.requestFocus()
                flag = false
            }
        }
        return flag
    }
}



