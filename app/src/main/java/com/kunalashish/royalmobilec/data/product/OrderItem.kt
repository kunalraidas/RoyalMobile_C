package com.kunalashish.royalmobilec.data.product

data class OrderItem(
    var product: Product? = null,
    var quantity : Int,
    var totalPrice :Float
)
