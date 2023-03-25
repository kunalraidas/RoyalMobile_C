package com.kunalashish.royalmobilec.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.databinding.FragmentMyCartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class fragment_my_cart : Fragment() {

    lateinit var binding: FragmentMyCartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyCartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        binding.root.removeAllViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.root.removeAllViews()
    }
}