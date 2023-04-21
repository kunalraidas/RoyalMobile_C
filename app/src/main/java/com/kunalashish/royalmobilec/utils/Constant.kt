package com.kunalashish.royalmobilec.utils

import com.kunalashish.royalmobilec.URL

object Constant {

    const val user_pref = "Customer"
    const val user_register = "register_email"
    const val user_login = "email"
    const val user_login_details ="login email"
    const val user_register_details="register email"

    fun urlMaker(imageurl :String): String {
        val fileName = imageurl.substringAfter("http://localhost:8007/storage/images/")
        return URL.IMAGE_PATH+fileName
        //http://localhost:8007/storage/images/image1679465705866.jpg
    }
}