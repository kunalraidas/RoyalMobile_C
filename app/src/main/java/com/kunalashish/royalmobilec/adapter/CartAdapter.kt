package com.kunalashish.royalmobilec.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.kunalashish.royalmobilec.data.product.Cart
import com.kunalashish.royalmobilec.databinding.CartItemNewLayoutBinding
import com.kunalashish.royalmobilec.utils.Constant
import com.kunalashish.royalmobilec.viewmodels.CartViewModel

class CartAdapter(val c: Context, val l: List<Cart>, val vm: CartViewModel) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(val binding: CartItemNewLayoutBinding) : ViewHolder(binding.root) {
        val imgCart = binding.imgCart
        val productName = binding.txtCartItemProductName
        val qty = binding.txtCartItemQuantityText
        val qtyName = binding.txtCartItemQuantity
        val total = binding.txtCartItemTotal
        val btnRemoveCart = binding.btnRemoveCartItem
        val btnPlus = binding.btnPlusCart
        val btnMinus = binding.btnMinusCart
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            CartItemNewLayoutBinding.inflate(LayoutInflater.from(c), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return l.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val p = l[position]
        with(holder) {
            Glide.with(c)
                .load(Constant.urlMaker(p.product!!.productColor!!.first().product_image!!))
                .into(imgCart)
            productName.text = p.product.product_name
            qty.text = p.quentity.toString()
            qtyName.text = "Quantity : ${p.quentity}"
            total.text = "Total : Rs ${p.total_price}"
            btnPlus.setOnClickListener {
                val q = p.quentity + 1
                if(q<=5){
                    vm.updateCart(q,p.email,p.product)
                }else{
                    Toast.makeText(c, "Max quantity is 5", Toast.LENGTH_SHORT).show()
                }

            }
            btnMinus.setOnClickListener {
                val q = p.quentity - 1
                if(q==0){
                    vm.msg.postValue("Quantity can not be less than 1")
                }else{
                    vm.updateCart(q,p.email,p.product)
                }
            }
            btnRemoveCart.setOnClickListener {
                val a = AlertDialog.Builder(c)
                a.setTitle("Remove this cart ?")
                a.setMessage("After removing you can add it later")
                a.setPositiveButton("Yes"){d,w->
                    vm.deleteCart(p.cart_id,p.email)
                }
                a.setNegativeButton("No"){d,w->
                    d.dismiss()
                }
                a.show()
            }
        }
    }
}