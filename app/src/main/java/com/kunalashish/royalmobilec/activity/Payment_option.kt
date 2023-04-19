package com.kunalashish.royalmobilec.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalashish.royalmobilec.databinding.ActivityPaymentOptionBinding

class Payment_option : AppCompatActivity() {
    lateinit var binding: ActivityPaymentOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPaymentOptionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}