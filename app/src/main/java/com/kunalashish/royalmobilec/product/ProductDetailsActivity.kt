package com.kunalashish.royalmobilec.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.activity.CartActivity
import com.kunalashish.royalmobilec.data.product.Product
import com.kunalashish.royalmobilec.data.response.Simple_Response
import com.kunalashish.royalmobilec.databinding.ActivityProductDetailsBinding
import com.kunalashish.royalmobilec.network.NetworkService
import com.kunalashish.royalmobilec.utils.Constant
import com.kunalashish.royalmobilec.utils.Constant.user_login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductDetailsBinding
    var product: Product? = null
    var email: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val p = intent.getSerializableExtra("product") as Product
        if (p != null)
            product = p

        val sharedPreferences = getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
        email = sharedPreferences.getString(user_login, null)

        setupData()
        setupClickListeners()
        setContentView(binding.root)
    }

    private fun setupClickListeners() {
        binding.btnAddToCart.setOnClickListener {
            if (product != null && email != null) {
                //add mobile
                if (!product!!.Mobile.isNullOrEmpty() && !product!!.productColor.isNullOrEmpty()) {
                    val r = NetworkService.networkInstance.addToCart(
                        email = email!!,
                        qty = 1,
                        mid = product!!.Mobile!!.first().mobile_id,
                        cid = product!!.productColor!!.first().color_id,
                        asid = null,
                        product = product!!
                    )
                    r.enqueue(object : Callback<Simple_Response?> {
                        override fun onResponse(
                            call: Call<Simple_Response?>,
                            response: Response<Simple_Response?>
                        ) {
                            if (response.body() != null) {
                                if (response!!.body()!!.success) {
                                    Toast.makeText(
                                        this@ProductDetailsActivity,
                                        "Added to cart",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    startActivity(Intent(this@ProductDetailsActivity,CartActivity::class.java))
                                } else {
                                    Toast.makeText(
                                        this@ProductDetailsActivity,
                                        "Error",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<Simple_Response?>, t: Throwable) {
                            Toast.makeText(
                                this@ProductDetailsActivity,
                                "${t.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                } else if (!product!!.Accessories.isNullOrEmpty() && !product!!.productColor.isNullOrEmpty()) {
                    val r = NetworkService.networkInstance.addToCart(
                        email = email!!,
                        qty = 1,
                        mid = null,
                        cid = product!!.productColor!!.first().color_id,
                        asid = product!!.Accessories!!.first().access_id,
                        product = product!!
                    )
                    r.enqueue(object : Callback<Simple_Response?> {
                        override fun onResponse(
                            call: Call<Simple_Response?>,
                            response: Response<Simple_Response?>
                        ) {
                            if (response.body() != null) {
                                if (response!!.body()!!.success) {
                                    Toast.makeText(
                                        this@ProductDetailsActivity,
                                        "Added to cart",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    startActivity(Intent(this@ProductDetailsActivity,CartActivity::class.java))
                                } else {
                                    Toast.makeText(
                                        this@ProductDetailsActivity,
                                        "Error",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<Simple_Response?>, t: Throwable) {
                            Toast.makeText(
                                this@ProductDetailsActivity,
                                "${t.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                }

            } else {
                Toast.makeText(this, "Email or product is null", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupData() {
        if (product != null) {
            with(binding) {
//                txtProductDescription.text = product!!.product_desc
                txtProductDescription.setText(product!!.product_desc)
                Glide.with(this@ProductDetailsActivity)
                    .load(product?.productColor?.first()?.product_image?.let {
                        Constant.urlMaker(
                            it
                        )
                    }).into(binding.productImagesViewpager)
                productTitle.text = product?.product_name.toString()
                productPrice.text = product?.Mobile?.first()?.price.toString()

            }
        }
    }
}