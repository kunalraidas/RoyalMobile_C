package com.kunalashish.royalmobilec.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kunalashish.royalmobilec.data.product.Order
import com.kunalashish.royalmobilec.databinding.OrderItemsBinding
import com.kunalashish.royalmobilec.product.OrderDetailsActivity
import com.kunalashish.royalmobilec.viewmodels.OrderViewModel

class AllOrderAdapter(val context: Context, val list : List<Order>, val vm : OrderViewModel) :
    RecyclerView.Adapter<AllOrderAdapter.AllOrderViewHolder>()
{
    class  AllOrderViewHolder(val binding : OrderItemsBinding) : ViewHolder(binding.root){

        val orderId = binding.txtOrderId
        val orderDate =  binding.txtOrderDate
//        val orderEmail = binding.txtOrderEmailId
        val orderTotalPrice = binding.txtOrderTotal
        val cardOrder = binding.cardOrder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllOrderViewHolder {
        return AllOrderViewHolder(
            OrderItemsBinding.inflate(LayoutInflater.from(context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AllOrderViewHolder, position: Int) {
        val s = list[position]
        with(holder){
            orderId.text = s.order_id
            orderDate.text = s.order_date.toString()
//            orderEmail.text = s.Email
            orderTotalPrice.text = s.total.toString()
            cardOrder.setOnClickListener {
                val i = Intent(context,OrderDetailsActivity::class.java)
                i.putExtra("order",s)
                context.startActivity(i)
            }
        }

    }
}






















