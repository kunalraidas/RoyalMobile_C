package com.kunalashish.royalmobilec

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kunalashish.royalmobilec.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        binding.haventAccount.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        binding.forgotPw.setOnClickListener {
            startActivity(Intent(this,Forgot_password_Activity::class.java))
        }
    }
}