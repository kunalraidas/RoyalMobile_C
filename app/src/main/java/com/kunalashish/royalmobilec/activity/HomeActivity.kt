package com.kunalashish.royalmobilec.activity


import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.kunalashish.royalmobilec.R

import com.kunalashish.royalmobilec.databinding.ActivityHomeBinding
import com.kunalashish.royalmobilec.fragment.AboutUsFragment
import com.kunalashish.royalmobilec.fragment.LogoutFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: Toolbar
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: NavigationView

    var previousItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = findViewById(R.id.drawerlayout)
        coordinatorLayout = findViewById(R.id.coordinatorlayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.NavigationView)

       // replaceFragment(DashboardFragment())
        setUpTollbar()
        openDashboard()

        val actionBarDrawerTogle = ActionBarDrawerToggle(
            this@HomeActivity,drawerLayout,R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerTogle)
        actionBarDrawerTogle.syncState()


        binding.NavigationView.setNavigationItemSelectedListener {

            if (previousItem != null){
                previousItem?.isChecked = false
            }

            it.isChecked = true
            it.isCheckable = true
            previousItem = it



            when(it.itemId){
                R.id.home -> {
                   openDashboard()
                    drawerLayout.closeDrawers()
                }

                R.id.notification -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame , NotificationFragment()
                    ).commit()

                    supportActionBar?.title = "Notification"
                    drawerLayout.closeDrawers()
                }

                R.id.rewards -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame , RewardsFragment()
                    ).commit()

                    supportActionBar?.title = "Rewards"
                    drawerLayout.closeDrawers()
                }

                R.id.favourites -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame , FavouritrsFragment()
                    ).commit()

                    supportActionBar?.title = "Favourites"
                    drawerLayout.closeDrawers()
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame , ProfileFragment()
                    ).commit()

                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }

                R.id.log_out -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame , LogoutFragment()
                    ).commit()

                    supportActionBar?.title = "Logout"
                    drawerLayout.closeDrawers()
                }
                R.id.information -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame , AboutUsFragment()
                        ).commit()

                    supportActionBar?.title = "About us"
                    drawerLayout.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true
        }
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame, fragment)
//        fragmentTransaction.commit()
//    }

    private fun setUpTollbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id =  item.itemId

        if (id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openDashboard(){
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.commit()
        supportActionBar?.title = "Dashboard"
        navigationView.setCheckedItem(R.id.home)
    }

    override fun onBackPressed() {

        val frag = supportFragmentManager.findFragmentById(R.id.frame)
        when(frag){
            !is  DashboardFragment -> openDashboard()

            else -> super.onBackPressed()
        }


    }

}
