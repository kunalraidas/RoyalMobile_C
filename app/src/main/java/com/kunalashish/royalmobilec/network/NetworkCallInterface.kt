package com.kunalashish.royalmobilec.network

import android.telecom.Call.Details
import com.kunalashish.royalmobilec.data.model.Login_Request
import com.kunalashish.royalmobilec.data.model.Register_Request
import com.kunalashish.royalmobilec.data.response.Simple_Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkCallInterface
{
    @POST("v1/customer/login")
    fun login(@Body loginDetails: Login_Request) : Call<Simple_Response>

    @POST("v1/customer/register")
    fun register(@Body registerDetails: Register_Request) : Call<Simple_Response>


}