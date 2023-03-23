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

  //      binding.userCardProfile.settingsBtn.setOnClickListener {
   //         startActivity(intent)
//            //startActivity(intent(this, EditProfileActivity::class.java))
  //      }


  //     binding.settingsBtn.setOnClickListener {
//            val intent  = Intent(requireContext(),EditProfileActivity::class.java)
//            startActivity(intent)
//        }

        return  binding.root
    }


}