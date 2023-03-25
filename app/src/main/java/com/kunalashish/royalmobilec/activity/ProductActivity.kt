package com.kunalashish.royalmobilec.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}