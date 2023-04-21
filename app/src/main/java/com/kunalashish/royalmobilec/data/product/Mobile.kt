package com.kunalashish.royalmobilec.data.product

data class Mobile(
    val mobile_id : Int = 0,
    var product_id : Int = 0,
    val ram : String = " ",
    val storage : String = "",
    val price : Float = 0f,
    val quentity : Int = 0
) : java.io.Serializable
