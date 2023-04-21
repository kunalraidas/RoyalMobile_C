package com.kunalashish.royalmobilec.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.data.models.Customer
import com.kunalashish.royalmobilec.data.product.OrderItem
import com.kunalashish.royalmobilec.databinding.ActivityOrderDetailsBinding
import com.kunalashish.royalmobilec.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderDetailsBinding
    var orderItem : OrderItem? = null
    var customerEmail : String ? = null
    var email: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val o = intent.getSerializableExtra("order") as  OrderItem
        isLoggedIn()
        getCustomer()

       // Toast.makeText(this@OrderDetailsActivity, o.toString(), Toast.LENGTH_SHORT).show()

        binding.productTitle.text = o.product?.product_name
        binding.productPrice.text = o.totalPrice.toString()
        Glide.with(this@OrderDetailsActivity)
            .load(o.product?.productColor?.first()?.product_image?.let {
                Constant.urlMaker(
                    it
                )
            }).into(binding.productImage)
        binding.productQuantity.text = o.quantity.toString()

        binding.totalItemsPrice.text = o.totalPrice.toString()
        binding.totalPrice.text = o.totalPrice.toString()

        setUpClickLisetner()


    }

    private fun setUpClickLisetner() {

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

    private fun getCustomer(){
        val b = customerEmail?.let {
            CartActivity.db.getCustomerDetails(it)
                .enqueue(object : Callback<Customer?> {
                    override fun onResponse(call: Call<Customer?>, response: Response<Customer?>) {
                        binding.fullname.text = response.body()?.first_name
                        binding.address.text = response.body()?.delivery_address
                        binding.pincode.text = response.body()?.pincode.toString()
//                        binding.CustomerName.text = response.body()?.first_name
//                        binding.address.text = response.body()?.delivery_address
//                        binding.pincode.text = response.body()?.pincode.toString()
                    }
                    override fun onFailure(call: Call<Customer?>, t: Throwable) {
                        Toast.makeText(this@OrderDetailsActivity, "Some Problem $t", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}