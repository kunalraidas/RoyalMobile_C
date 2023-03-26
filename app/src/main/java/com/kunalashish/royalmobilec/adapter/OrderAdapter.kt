package com.kunalashish.royalmobilec.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.data.product.Cart
import com.kunalashish.royalmobilec.data.product.CartList
import com.kunalashish.royalmobilec.data.product.Order
import com.kunalashish.royalmobilec.databinding.OrderDetailsLayoutBinding
import com.kunalashish.royalmobilec.databinding.OrderItemNewLayoutBinding
import com.kunalashish.royalmobilec.utils.Constant
import com.kunalashish.royalmobilec.viewmodels.OrderViewModel

class OrderAdapter(val context: Context, val l: List<Order?>, val vm: OrderViewModel):
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    class OrderViewHolder(val binding: OrderItemNewLayoutBinding) : ViewHolder(binding.root) {

        val productImage = binding.imgOrder
        val productName  = binding.txtOrderItemProductName
        val productPrice = binding.txtOrderItemTotal
        val productQuentity = binding.txtOrderItemQuantity


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            //OrderDetailsLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
         OrderItemNewLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return l.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
            val p = l[position]
            with(holder){
                Glide.with(context)
                    .load(
                        p?.orderItems?.first()?.product?.productColor?.first()?.product_image?.let {
                            Constant.urlMaker(
                                it
                            )
                        }
                        ).into(productImage)


            }

    }

    }













// val p = l[position]
//        with(holder){
//            Glide.with(context)
//                .load(
