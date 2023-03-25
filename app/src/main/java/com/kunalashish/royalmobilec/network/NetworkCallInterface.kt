package com.kunalashish.royalmobilec.network

import android.telecom.Call.Details
import com.kunalashish.royalmobilec.data.model.Login_Request
import com.kunalashish.royalmobilec.data.model.Register_Request
import com.kunalashish.royalmobilec.data.models.Customer
import com.kunalashish.royalmobilec.data.product.*
import com.kunalashish.royalmobilec.data.response.Simple_Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NetworkCallInterface {
    @POST("v1/customer/login")
    fun login(@Body loginDetails: Login_Request): Call<Simple_Response>

    @POST("v1/customer/register")
    fun register(@Body registerDetails: Register_Request): Call<Simple_Response>

    @GET("product/getAllProduct")
    fun getAllProduct(): Call<List<Product>>

    @GET("category/get-category-id")
    fun getCategoryById(@Query("cate_id") id: Int): Call<Category>

    @GET("product/getAllMobile")
    fun getAllMobiles(): Call<List<Mobile>>

    @GET("product/getAllAccessories")
    fun getAllAccessories(): Call<List<Accessories>>

    @GET("brand/getAll")
    fun getBrand(): Call<List<Brand>>

    @GET("category/getAll")
    fun getCategory(): Call<List<Category>>

    @GET("customer/get")
    fun getCustomerDetails(@Query("email") email: String): Call<Customer>

    @POST("cart/add")
    fun addToCart(
        @Query("email") email: String,
        @Query("qty") qty: Int,
        @Query("mobile_id") mid: Int?,
        @Query("color_id") cid: Int?,
        @Query("access_id") asid: Int?,
        @Body product: Product
    ) : Call<Simple_Response>

    @GET("cart/get_cart_by_email")
    fun getCartById(@Query("email") email : String) : Call<List<Cart>>

    @POST("cart/update")
    fun updateCartQuantity(@Query("email") email : String,@Body p : Product,@Query("qty") qty : Int) : Call<Simple_Response>

    @POST("cart/delete")
    fun deleteCart(@Query("cart_id") id : Int) : Call<Simple_Response>

    @POST("order/add")
    fun addOrder(@Body cartList : CartList) : Call<Simple_Response>
}