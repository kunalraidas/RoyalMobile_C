package com.kunalashish.royalmobilec.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kunalashish.royalmobilec.data.product.Order
import com.kunalashish.royalmobilec.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderViewModel : ViewModel() {
    val orders = MutableLiveData<List<Order>?>()
    val msg = MutableLiveData<String>("")

    companion object {
        val db = NetworkService.networkInstance
    }

    fun getAllOrder(email: String) {
        val r = db.getOrderByEmail(email)
        r.enqueue(object : Callback<List<Order>?> {
            override fun onResponse(
                call: Call<List<Order>?>,
                response: Response<List<Order>?>
            ) {
                if (response.body() != null) {
                    val c = response.body()?.sortedBy {
                        it.order_id
                    }
                    orders.postValue(c)
                        msg.postValue(c.toString())
                }
            }

            override fun onFailure(call: Call<List<Order>?>, t: Throwable) {
                msg.postValue("$t")
            }
        })
    }


}