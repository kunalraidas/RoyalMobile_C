package com.kunalashish.royalmobilec.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kunalashish.royalmobilec.data.product.Cart
import com.kunalashish.royalmobilec.data.product.Product
import com.kunalashish.royalmobilec.data.response.Simple_Response
import com.kunalashish.royalmobilec.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartViewModel : ViewModel() {

    val carts = MutableLiveData<List<Cart>>()
    val msg = MutableLiveData<String>("")

    companion object{
        val db = NetworkService.networkInstance
    }

    fun getAllCarts(email : String){
        val r = db.getCartById(email)
        r.enqueue(object : Callback<List<Cart>?> {
            override fun onResponse(call: Call<List<Cart>?>, response: Response<List<Cart>?>) {
                if(response.body()!=null){
                    carts.postValue(response.body())
                }else{
                    msg.postValue("Resposne is null")
                }
            }

            override fun onFailure(call: Call<List<Cart>?>, t: Throwable) {
                msg.postValue("$t")
            }
        })
    }

    fun updateCart(qty : Int,email : String,p : Product){
        val r = db.updateCartQuantity(email,p,qty)
        r.enqueue(object : Callback<Simple_Response?> {
            override fun onResponse(
                call: Call<Simple_Response?>,
                response: Response<Simple_Response?>
            ) {
                if(response.body()!=null){
                    msg.postValue("Quantity Updated")
                }else{
                    msg.postValue("Resposne is null")
                }
            }

            override fun onFailure(call: Call<Simple_Response?>, t: Throwable) {
                msg.postValue("$t")
            }
        })
    }
}