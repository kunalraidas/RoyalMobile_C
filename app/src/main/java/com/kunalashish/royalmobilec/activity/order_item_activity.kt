package com.kunalashish.royalmobilec.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalashish.royalmobilec.databinding.ActivityOrderItemBinding

class order_item_activity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOrderItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}