package com.kunalashish.royalmobilec.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalashish.royalmobilec.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}