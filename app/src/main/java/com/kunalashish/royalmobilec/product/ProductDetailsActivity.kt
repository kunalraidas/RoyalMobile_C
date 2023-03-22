package com.kunalashish.royalmobilec.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.data.product.Product
import com.kunalashish.royalmobilec.databinding.ActivityProductDetailsBinding
import com.kunalashish.royalmobilec.utils.Constant

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityProductDetailsBinding
    var product : Product? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val p = intent.getSerializableExtra("product") as Product
        if(p != null)
            product = p

        setupData()
        setContentView(binding.root)
    }

    private fun setupData() {
        if(product!=null){
            with(binding){
                txtProductDescription.text = product!!.product_desc
                Glide.with(this@ProductDetailsActivity).load(product?.productColor?.first()?.product_image?.let {
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