package com.kunalashish.royalmobilec.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.data.models.Customer
import com.kunalashish.royalmobilec.databinding.FragmentProfileBinding
import com.kunalashish.royalmobilec.network.NetworkService
import com.kunalashish.royalmobilec.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    var customerEmail : String ? = null

    //    val intent = Intent(activity, EditProfileActivity::class.java)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)


        isLoggedIn()
        getCustomer()

        binding.settingsBtn.setOnClickListener {
            // for Edit Profile
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }
        binding.btnSeeMore2.setOnClickListener {
            // For cart
            val intent1 = Intent(activity, CartActivity::class.java)
            startActivity(intent1)
        }

        binding.btnSeeMore3.setOnClickListener {
            // for order
            val intent2 = Intent(activity,OrderActivity::class.java)
            startActivity(intent2)
        }
        return binding.root
    }
    companion object{
        val db = NetworkService.networkInstance
    }

    private fun getCustomer(){
        val b = customerEmail?.let {
            db.getCustomerDetails(it)
                .enqueue(object : Callback<Customer?> {
                    override fun onResponse(call: Call<Customer?>, response: Response<Customer?>) {
                        binding.username.text = response.body()?.first_name
                        binding.userEmail.text = response.body()?.email
                    }

                    override fun onFailure(call: Call<Customer?>, t: Throwable) {
                        Toast.makeText(requireContext(), "Some Problem $t", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    private fun isLoggedIn(): String? {
        val sharedPreferences = requireContext().getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
        customerEmail = sharedPreferences.getString(Constant.user_login,null)
        if (!customerEmail.isNullOrEmpty())
        {
            return customerEmail
//            startActivity(Intent(this,MainActivity::class.java))
//            finish()
        }
        return null
    }
}
