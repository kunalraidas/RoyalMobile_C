package com.kunalashish.royalmobilec.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.data.product.Category
import com.kunalashish.royalmobilec.data.product.Product
import com.kunalashish.royalmobilec.databinding.HorizontalScrollItemLayoutBinding
import com.kunalashish.royalmobilec.network.NetworkCallInterface
import com.kunalashish.royalmobilec.network.NetworkService
import com.kunalashish.royalmobilec.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllProductsAdapter(val c: Context, val l: List<Product>,val db : NetworkCallInterface) :
    RecyclerView.Adapter<AllProductsAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: HorizontalScrollItemLayoutBinding) :
        ViewHolder(binding.root) {
        val imgProductImage = binding.imgProductImage
        val productName = binding.txtProductName
        val productCategory = binding.txtProductCategory
        val productPrice = binding.txtProductPrice
        val addtoFavourite = binding.btnAddToWishlist
        val productCard = binding.productCard

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            HorizontalScrollItemLayoutBinding.inflate(
                LayoutInflater.from(c),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return l.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val i = l[position]
        with(holder){
            Glide.with(c).load(Constant.urlMaker(i.productColor?.first()?.product_image!!)).into(imgProductImage)
            productName.text = i.product_name
            productPrice.text = i.Mobile?.first()?.price.toString()
            productCard.setOnClickListener {
                Toast.makeText(c,"$i",Toast.LENGTH_LONG).show()
            }
            getCatById(i.cate_id!!){
                productCategory.text = it
            }
            imgProductImage.setOnClickListener {
                Toast.makeText(c,"$i",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getCatById(id : Int,s : (String)-> Unit){
        var d = db.getCategoryById(id)
        d.enqueue(object : Callback<Category?> {
            override fun onResponse(call: Call<Category?>, response: Response<Category?>) {
                if(response.body()!=null){
                    s(response.body()!!.cate_name)
                }
            }

            override fun onFailure(call: Call<Category?>, t: Throwable) {
                Toast.makeText(c, "$t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}