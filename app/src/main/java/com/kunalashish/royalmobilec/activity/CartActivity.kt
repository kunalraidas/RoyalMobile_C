package com.kunalashish.royalmobilec.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kunalashish.royalmobilec.adapter.CartAdapter
import com.kunalashish.royalmobilec.data.product.Cart
import com.kunalashish.royalmobilec.data.product.CartList
import com.kunalashish.royalmobilec.databinding.ActivityCartBinding
import com.kunalashish.royalmobilec.utils.Constant
import com.kunalashish.royalmobilec.viewmodels.CartViewModel

class CartActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    lateinit var vm : CartViewModel
    var email: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this).get(CartViewModel::class.java)

        val sharedPreferences = getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
        email = sharedPreferences.getString(Constant.user_login, null)

        //get all carts
        if(email!=null){
            vm.getAllCarts(email!!)
        }
        setupObservers()
        setupClickListeners()
        setContentView(binding.root)
    }

    private fun setupClickListeners() {
        binding.btnOrderNow.setOnClickListener {
            val c = CartList(vm.carts.value!!)
            vm.addOrder(c)
//            val intent = Intent(this@CartActivity,order_item_activity::class.java)
//            startActivity(intent)
        }
    }

    private fun setupObservers() {
        vm.carts.observe(this){
            if(!it.isNullOrEmpty()){
                binding.cartItemsRecyclerview.adapter = CartAdapter(this,it,vm)
                var total = 0f
                it.forEach {
                    total+=it.total_price
                }
                binding.totalCartAmount.text = "Rs. $total"
            }
        }
        vm.msg.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}