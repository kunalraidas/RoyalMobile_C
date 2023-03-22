package com.kunalashish.royalmobilec.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalashish.royalmobilec.databinding.ActivityDeliverBinding

class DeliverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeliverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliverBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}