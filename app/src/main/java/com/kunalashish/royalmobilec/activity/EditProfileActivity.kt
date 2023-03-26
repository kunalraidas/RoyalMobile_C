package com.kunalashish.royalmobilec.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kunalashish.royalmobilec.data.models.Customer
import com.kunalashish.royalmobilec.databinding.ActivityEditProfileBinding
import com.kunalashish.royalmobilec.databinding.FragmentProfileBinding
import com.kunalashish.royalmobilec.network.NetworkService
import com.kunalashish.royalmobilec.utils.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    var customerEmail : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isLoggedIn()
        getCustomer()

    }

    private fun getCustomer(){
        val a = customerEmail?.let {
            NetworkService.networkInstance.getCustomerDetails(it)
                .enqueue(object : Callback<Customer?> {
                    override fun onResponse(call: Call<Customer?>, response: Response<Customer?>) {
                        binding.editFirstName.setText(response.body()?.first_name)
                        binding.editLastName.setText(response.body()?.last_name)
                        binding.editPhone.setText(response.body()?.phone_no.toString())
                        binding.editEmailName.setText(response.body()?.email)
                        binding.etPinCode.setText(response.body()?.pincode.toString())
                        binding.editAddress.setText(response.body()?.cust_Address)
                    }

                    override fun onFailure(call: Call<Customer?>, t: Throwable) {
                        Toast.makeText(this@EditProfileActivity, "Some Problem occur", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    private fun isLoggedIn(): String? {
        val sharedPreferences = getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
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