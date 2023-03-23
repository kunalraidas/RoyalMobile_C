package com.kunalashish.royalmobilec.activity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.databinding.ActivityHomeBinding



class HomeActivity : AppCompatActivity() {


    private lateinit var binding : ActivityHomeBinding
    private  var previousItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(DashboardFragment())

        binding.bottomNavigation.setOnItemSelectedListener{
           if(previousItem != null){
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
             true
            // this code is not work it show error so i use only true
           // return@setNavigationItemSelectedListener true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }
}

// return@setNavigationItemSelectedListener true
//                R.id.notification -> {
//                    replaceFragment(NotificationFragment())
//                    //drawerLayout.closeDrawers()
//                }
//                R.id.rewards -> {
//                    // replaceFragment()
//                    replaceFragment(RewardsFragment())
//                    // drawerLayout.closeDrawers()
//                }
//                R.id.order -> {
//                    replaceFragment(OrderFragment())
//                    //  drawerLayout.closeDrawers()
//                }
//                R.id.Cart -> {
//                    replaceFragment(CartFragment())
//                    //replaceFragment(CartFragment())
//                    // drawerLayout.closeDrawers()
//                }




//        binding.NavigationView.setNavigationItemSelectedListener {
//            if (previousItem != null) {
//                previousItem?.isChecked = false
//            }
//
//            it.isCheckable = true
//            it.isChecked = true
//            previousItem = it
//
//                return@setNavigationItemSelectedListener
//
//        }

    /* @SuppressLint("RestrictedApi")
   fun setUpToolbar(toolbar: Toolbar){
       setSupportActionBar(toolbar)
       supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
       supportActionBar?.setHomeButtonEnabled(true)
   }*/



//binding = ActivityMainBinding.inflate(layoutInflater)
//
//setContentView(binding.root)
//

//}

