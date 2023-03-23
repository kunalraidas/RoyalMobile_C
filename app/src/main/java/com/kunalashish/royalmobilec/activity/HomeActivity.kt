package com.kunalashish.royalmobilec.activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.ResetPassword
import com.kunalashish.royalmobilec.adapter.MainViewPagerAdapter
import com.kunalashish.royalmobilec.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    var previousItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(DashboardFragment())
        setupViewPager()


        binding.NavigationView.setNavigationItemSelectedListener {
            if (previousItem != null) {
                previousItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousItem = it


            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(DashboardFragment())
                    //drawerLayout.closeDrawers()

                }
                R.id.notification -> {
                    replaceFragment(NotificationFragment())
                    //drawerLayout.closeDrawers()
                }
                R.id.rewards -> {
                    // replaceFragment()
                    replaceFragment(RewardsFragment())
                    // drawerLayout.closeDrawers()
                }
                R.id.order -> {
                    replaceFragment(OrderFragment())
                    //  drawerLayout.closeDrawers()
                }
                R.id.Cart -> {
                    replaceFragment(CartFragment())
                    //replaceFragment(CartFragment())
                    // drawerLayout.closeDrawers()
                }
                R.id.favourites -> {
                    replaceFragment(FavouritrsFragment())
                    //  drawerLayout.closeDrawers()
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    // drawerLayout.closeDrawers()
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

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }

    private fun setupViewPager() {
        val flist = listOf(DashboardFragment(), CartFragment(), ProfileFragment())
        binding.viewPager.adapter = MainViewPagerAdapter(flist, this@HomeActivity)
        binding.bottomNavigationView.setupWithViewPager2(binding.viewPager)
    }
}
