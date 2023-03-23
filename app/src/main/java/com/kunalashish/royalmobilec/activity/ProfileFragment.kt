package com.kunalashish.royalmobilec.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding
//    val intent = Intent(activity, EditProfileActivity::class.java)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        binding.settingsBtn.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }
        binding.btnSeeMore2.setOnClickListener {
            val intent1 = Intent(activity, CartActivity::class.java)
            startActivity(intent1)
        }
        binding.btnSeeMore3.setOnClickListener {
            val intent2 = Intent(activity, OrderDetailsActivity::class.java)
            startActivity(intent2)
        }
         return  binding.root
//    binding.settingsBtn.setOnClickListener {
//        startActivity(intent)
//    }
    }


}
//      binding.userCardProfile.settingsBtn.setOnClickListener {
//         startActivity(intent)
//            //startActivity(intent(this, EditProfileActivity::class.java))
//      }


//     binding.settingsBtn.setOnClickListener {
//            val intent  = Intent(requireContext(),EditProfileActivity::class.java)
//            startActivity(intent)
//        }