package com.kunalashish.royalmobilec.data.product

data class OrderItem(
    var product: Product? = null,
    var quantity : Int = 0,
    var totalPrice :Float = 0f
) : java.io.Serializable
