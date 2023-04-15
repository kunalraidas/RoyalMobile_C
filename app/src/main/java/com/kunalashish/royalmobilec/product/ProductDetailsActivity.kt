package com.kunalashish.royalmobilec.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.activity.CartActivity
import com.kunalashish.royalmobilec.data.product.Mobile
import com.kunalashish.royalmobilec.data.product.Product
import com.kunalashish.royalmobilec.data.product.ProductColor
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

    var mMobile = mutableListOf<Mobile>()
    var mColor = mutableListOf<ProductColor>()

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
        setupSpinnerSelection()
        setContentView(binding.root)
    }

    private fun setupSpinnerSelection() {
        binding.mobileRam.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var ramId = 0
                var text = ""
                if(!mMobile.isNullOrEmpty()){
                    text = (view as TextView).text.toString()
                    ramId = mMobile.filter {
                        it.ram == text
                    }.map {
                        it.mobile_id
                    }.first()
                }
                Toast.makeText(this@ProductDetailsActivity, "$text $ramId", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.mobileStorage.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var storageId = 0
                var text = ""
                if(!mMobile.isNullOrEmpty()){
                    text = (view as TextView).text.toString()
                    storageId = mMobile.filter {
                        it.storage == text
                    }.map {
                        it.mobile_id
                    }.first()
                }
                Toast.makeText(this@ProductDetailsActivity, "$text $storageId", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    private fun setupClickListeners() {
        binding.btnAddToCart.setOnClickListener {
            if (product != null && email != null) {
                //add mobile
                if (!product!!.Mobile.isNullOrEmpty() && !product!!.productColor.isNullOrEmpty()) {


                    val mId = mMobile.filter {
                        val view = binding.mobileRam.selectedView as TextView
                        it.ram == view.text.toString()
                    }.map {
                        it.mobile_id
                    }.first()

                    val cId = mColor.filter {
                        val view = binding.mobileColor.selectedView as TextView
                        it.color_name == view.text
                    }.map {
                        it.color_id
                    }.first()


                    val r = NetworkService.networkInstance.addToCart(
                        email = email!!,
                        qty = 1,
                        mid = mId,
                        cid = cId,
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

                    val cId = mColor.filter {
                        val view = binding.AccesssColor.selectedView as TextView
                        it.color_name == view.text
                    }.map {
                        it.color_id
                    }.first()



                    val r = NetworkService.networkInstance.addToCart(
                        email = email!!,
                        qty = 1,
                        mid = null,
                        cid =cId,
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
                if(!product?.Mobile.isNullOrEmpty()){
                    binding.llMobile.visibility = View.VISIBLE
                    loadMobileSpinners(product!!.Mobile,product!!.productColor)
                }else{
                    binding.llMobile.visibility = View.GONE
                }

                if(!product!!.Accessories.isNullOrEmpty()){
                    binding.llAccess.visibility = View.VISIBLE
                    loadAccessSpinners(product!!)
                }else{
                    binding.llAccess.visibility = View.GONE
                }


            }
        }
    }

    private fun loadAccessSpinners(product: Product) {
        val color = product.productColor?.sortedBy {
            it.color_id

        }
        val adpAsc = color?.let {
            ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, it.map {
                it.color_name.toString()
            })
        }
        binding.AccesssColor.adapter = adpAsc
    }

    private fun loadMobileSpinners(mobile: List<Mobile>?, productColor: List<ProductColor>?) {
        val l = mobile!!.sortedBy {
            it.mobile_id
        }
        mMobile = l.toMutableList()
        val adpRam = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,l.map {
            it.ram.toString()
        })
        binding.mobileRam.adapter = adpRam

        val adpStorage =  ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,l.map {
            it.storage.toString()
        })

        binding.mobileStorage.adapter = adpStorage

        val color = productColor!!.sortedBy {
            it.color_id
        }
        val adpColor = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,color.map {
            it.color_name
        })

        mColor = color.toMutableList()

        binding.mobileColor.adapter = adpColor

    }
}