package com.kunalashish.royalmobilec.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kunalashish.royalmobilec.adapter.OrderAdapter
import com.kunalashish.royalmobilec.databinding.ActivityOrderItemBinding
import com.kunalashish.royalmobilec.viewmodels.OrderViewModel

class order_item_activity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderItemBinding
    lateinit var vm : OrderViewModel
    var email: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOrderItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)


//        binding.imgCart.setOnClickListener {
//            startActivity(Intent(this, OrderDetailsActivity::class.java))
//        }

        vm = ViewModelProvider(this).get(
           OrderViewModel::class.java
        )

        setContentView(binding.root)
    }

    private fun setUpObserver(){
            vm.orders.observe(this){
                if (!it.isNullOrEmpty()){
                   binding.allOrderActivity.adapter = OrderAdapter(this,it,vm)
                }
            }
    }
}