package com.kunalashish.royalmobilec.data.product

data class Mobile(
    val mobile_id : Int,
    var product_id : Int,
    val ram : String,
    val storage : String,
    val price : Float,
    val quentity : Int
) : java.io.Serializable
