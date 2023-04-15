package com.kunalashish.royalmobilec.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kunalashish.royalmobilec.data.product.Order
import com.kunalashish.royalmobilec.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllOrderViewModel : ViewModel() {

    val orders = MutableLiveData<List<Order>>()
    val msg = MutableLiveData<String>("")

    companion object{
        val db = NetworkService.networkInstance
    }

    fun getAllOrder(order_id : String){
        val upsc = db.getOrderByOrderId(order_id)
        upsc.enqueue(object : Callback<Order?> {
            override fun onResponse(call: Call<Order?>, response: Response<Order?>) {
                if (response.body() != null){
                    val o = response.body()
                }
            }

            override fun onFailure(call: Call<Order?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}