package com.kunalashish.royalmobilec.data.product

import java.time.LocalDate

data class Order(
    val order_id : String = "",
    val Email : String = "",
//    val cart_id :  Int,
    val order_date : LocalDate? = null,
    val orderItems : List<OrderItem>?= null,
    val quantity : Int? = null,
    val trackingUrl : String?=null,
    val orderStatus : Int = 0,
    val paymentStatus : Int = 0,
    val total : Float = 0.0f,
    val discount : Float = 0.0f,
    val deliveryCharge : Float = 0f,
    val totalrecived : Float = 0f,
    val mobile_id : Int? = null,
    val color_id : Int? = null,
    val accessories_id : Int? = null,

) : java.io.Serializable
