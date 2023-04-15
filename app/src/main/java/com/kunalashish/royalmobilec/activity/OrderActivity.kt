package com.kunalashish.royalmobilec.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.adapter.AllOrderAdapter
import com.kunalashish.royalmobilec.databinding.ActivityOrderBinding
import com.kunalashish.royalmobilec.utils.Constant
import com.kunalashish.royalmobilec.viewmodels.OrderViewModel

class OrderActivity : AppCompatActivity() {

    lateinit var binding : ActivityOrderBinding
    private  lateinit var vm : OrderViewModel
     var email : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)

        vm = ViewModelProvider(this)[OrderViewModel::class.java]

        val sharedPreferences = getSharedPreferences(Constant.user_pref,Context.MODE_PRIVATE)
        email = sharedPreferences.getString(Constant.user_login,null)

        if (email!= null){
            vm.getAllOrder(email!!)
        }else{
            Toast.makeText(this, "Email is null", Toast.LENGTH_SHORT).show()
        }

        setupObserver()
        setUpClickListener()

        setContentView(binding.root)
    }

    private fun setUpClickListener() {

    }

    private fun setupObserver() {
        vm.orders.observe(this){

            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
            binding.recycleOrder.adapter = AllOrderAdapter(this,it!!,vm)
//                binding.recycleOrder.adapter = OrderAdapter(this,it,vm)


        }
        vm.msg.observe(this){
           // binding.errorMessageForOrder.text = it.toString()
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}