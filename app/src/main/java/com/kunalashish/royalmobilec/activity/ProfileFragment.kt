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

    lateinit var binding : FragmentProfileBinding
    var customerEmail : String ? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = FragmentProfileBinding.inflate(inflater,container,false)

        isLoggedIn()
        //getCustomer()

        binding.settingsBtn.setOnClickListener {
            val intent  = Intent(requireContext(),EditProfileActivity::class.java)
            startActivity(intent)
        }

        return  binding.root
    }

//    private fun getCustomer() {
//        val a = customerEmail?.let {
//            NetworkService.networkInstance.getCustomerDetails(it).enqueue(object : Callback<Customer?> {
//                override fun onResponse(call: Call<Customer?>, response: Response<Customer?>) {
//                    binding.editFirstName.setText(response.body()?.first_name)
//                    binding.editLastName.setText(response.body()?.last_name)
//                    binding.userEmail.text = response.body()?.email
//                    binding.editPhone.setText(response.body()?.phone_no.toString())
//                    binding.editAddress.setText(response.body()?.cust_Address)
//                    binding.username.text = response.body()?.first_name
//                }
//
//                override fun onFailure(call: Call<Customer?>, t: Throwable) {
//                    Toast.makeText(requireContext(), "Fail ${t.message}", Toast.LENGTH_SHORT).show()
//                }
//            })
//        }
//    }


    private fun isLoggedIn(): String? {
        val sharedPreferences = requireContext().getSharedPreferences(Constant.user_pref, Context.MODE_PRIVATE)
        customerEmail = sharedPreferences.getString(Constant.user_login,null)
        if (!customerEmail.isNullOrEmpty())
        {
            return customerEmail
        }
        return null

    }

}