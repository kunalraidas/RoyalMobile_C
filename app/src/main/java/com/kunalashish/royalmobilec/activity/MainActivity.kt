package com.kunalashish.royalmobilec.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.utils.Constant

class MainActivity : AppCompatActivity() {

    var customerEmail : String ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val runnable = Runnable { // this code will run after 2 seconds
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            finish()
        }
        Handler().postDelayed(runnable, 2000)

    }

    private fun isLoggedIn(){
        val sharedPreferences = getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
        customerEmail = sharedPreferences.getString(Constant.user_login,null)
        if (!customerEmail.isNullOrEmpty())
        {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
    }
}