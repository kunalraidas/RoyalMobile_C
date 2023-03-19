package com.kunalashish.royalmobilec.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.kunalashish.royalmobilec.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val runnable = Runnable { // this code will run after 2 seconds
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }
        Handler().postDelayed(runnable, 2000)


    }
}