package com.kunalashish.royalmobilec.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalashish.royalmobilec.data.product.Order
import com.kunalashish.royalmobilec.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
//        val o = Order()
//        when(o.orderStatus){
//            0->{
//                binding.oDetails.orderedPackedProgress.setProgress(100)
//            }
//            1->{
//                binding.oDetails.orderedPackedProgress.setProgress(100)
//            }
//        }
        setContentView(binding.root)
    }
}