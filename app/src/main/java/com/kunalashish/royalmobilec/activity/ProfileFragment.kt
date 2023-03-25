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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
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
            val intent2 = Intent(activity, order_item_activity::class.java)
            startActivity(intent2)
        }
         return  binding.root
        }

    override fun onPause() {
        super.onPause()
       // binding.root.removeAllViews()
    }

    override fun onDestroy() {
        super.onDestroy()
       // binding.root.removeAllViews()
    }
}



