package com.kunalashish.royalmobilec.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.kunalashish.royalmobilec.adapter.CartAdapter
import com.kunalashish.royalmobilec.data.models.Customer
import com.kunalashish.royalmobilec.data.product.CartList
import com.kunalashish.royalmobilec.databinding.ActivityCartBinding
import com.kunalashish.royalmobilec.network.NetworkService
import com.kunalashish.royalmobilec.utils.Constant
import com.kunalashish.royalmobilec.viewmodels.CartViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    var customerEmail : String ? = null
    lateinit var vm : CartViewModel
    var email: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)

        getCustomer()

        vm = ViewModelProvider(this).get(CartViewModel::class.java)

        val sharedPreferences = getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
        email = sharedPreferences.getString(Constant.user_login, null)

        //get all carts
        if(email!=null){
            vm.getAllCarts(email!!)
        }
        setupObservers()
        setupClickListeners()
       // getCustomerDetails()

        isLoggedIn()
        setContentView(binding.root)
    }

    private fun setupClickListeners() {
        binding.btnOrderNow.setOnClickListener {

            val b = AlertDialog.Builder(this)

            b.setTitle("Confirm order ")
            b.setMessage("Click yes to confirm ")
            b.setPositiveButton("Yes"){d,w ->

                val c = CartList(vm.carts.value!!)
                vm.addOrder(c)
            }
            b.setNegativeButton("No"){d,w ->
                Toast.makeText(this@CartActivity, "Order canceled", Toast.LENGTH_SHORT).show()
                d.dismiss()
            }
            b.show()
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
    companion object{
        val db = NetworkService.networkInstance
    }

    private fun getCustomer(){
        val b = customerEmail?.let {
            db.getCustomerDetails(it)
                .enqueue(object : Callback<Customer?> {
                    override fun onResponse(call: Call<Customer?>, response: Response<Customer?>) {
                        binding.CustomerName.text = response.body()?.first_name
                        binding.address.text = response.body()?.delivery_address
                        binding.pincode.text = response.body()?.pincode.toString()
                    }
                    override fun onFailure(call: Call<Customer?>, t: Throwable) {
                        Toast.makeText(this@CartActivity, "Some Problem $t", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    private fun isLoggedIn(): String? {
        val sharedPreferences = getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
        customerEmail = sharedPreferences.getString(Constant.user_login,null)
        if (!customerEmail.isNullOrEmpty())
        {
            return customerEmail
        }
        return null
    }
}