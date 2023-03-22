package com.kunalashish.royalmobilec.data.product

data class ProductColor(
    val color_id : Int,
    val color_name : String,
    val product_image : String? = null,
) : java.io.Serializable
