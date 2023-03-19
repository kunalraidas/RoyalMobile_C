package com.kunalashish.royalmobilec.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalashish.royalmobilec.databinding.ActivityForgotPasswordBinding

class Forgot_password_Activity : AppCompatActivity() {

    private lateinit var binding:ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_forgot_password)

        binding.rstPassGoBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}