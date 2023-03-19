package com.kunalashish.royalmobilec.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
   private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(DashboardFragment())

       binding.NavigationView.setNavigationItemSelectedListener {

           when(it.itemId){
              R.id.home ->
              {
                  replaceFragment(DashboardFragment())
                      drawerLayout.closeDrawers()

              }
               R.id.notification ->
               {
                   replaceFragment(NotificationFragment())
                   drawerLayout.closeDrawers()
               }
               R.id.rewards ->
               {
                   replaceFragment(RewardsFragment())
                   drawerLayout.closeDrawers()
               }
               R.id.order ->
               {
                   replaceFragment(OrderFragment())
                   drawerLayout.closeDrawers()
               }
               R.id.Cart ->
               {
                   replaceFragment(CartFragment())
                   drawerLayout.closeDrawers()
               }
               R.id.favourites ->
               {
                   replaceFragment(FavouritrsFragment())
                   drawerLayout.closeDrawers()
               }
               R.id.profile ->
               {
                   replaceFragment(ProfileFragment())
                   drawerLayout.closeDrawers()
               }
           }
           return@setNavigationItemSelectedListener true
       }
    }
   /* @SuppressLint("RestrictedApi")
    fun setUpToolbar(toolbar: Toolbar){
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }*/

    private fun replaceFragment(fragment:Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,fragment)
        fragmentTransaction.commit()
    }



}