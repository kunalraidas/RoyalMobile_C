package com.kunalashish.royalmobilec.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.data.product.OrderItem
import com.kunalashish.royalmobilec.databinding.OrderItemNewLayoutBinding
import com.kunalashish.royalmobilec.utils.Constant

class OrderDetailsAdapter(val c: Context, val list: List<OrderItem>) :
    RecyclerView.Adapter<OrderDetailsAdapter.OrderItemViewHolder>() {

    class OrderItemViewHolder(val binding: OrderItemNewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

            val txtProductName = binding.txtOrderItemProductName
            val txtProductPrice = binding.txtOrderItemTotal
            val txtProductQty = binding.txtOrderItemQuantity
            val imgProduct = binding.imgOrder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        return OrderItemViewHolder(
            OrderItemNewLayoutBinding.inflate(
                LayoutInflater.from(c),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        val p = list[position]
        with(holder){
            txtProductName.text = p.product?.product_name.toString()
            txtProductQty.text = "Quantity : ${p.quantity}"
            txtProductPrice.text = "Rs . ${p.totalPrice}"
            Glide.with(c).load(Constant.urlMaker(p.product?.productColor?.first()?.product_image!!)).into(imgProduct)
        }
    }
}