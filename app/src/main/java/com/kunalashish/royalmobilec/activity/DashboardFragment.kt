package com.kunalashish.royalmobilec.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.adapter.AllProductsAdapter
import com.kunalashish.royalmobilec.data.product.Product
import com.kunalashish.royalmobilec.databinding.FragmentDashboardBinding
import com.kunalashish.royalmobilec.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {

    lateinit var binding : FragmentDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object{
        val db = NetworkService.networkInstance
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        binding =   FragmentDashboardBinding.bind(view)

        loadProducts()
        return binding.root
    }

    private fun loadProducts() {
        val r = db.getAllProduct()
        r.enqueue(object : Callback<List<Product>?> {
            override fun onResponse(
                call: Call<List<Product>?>,
                response: Response<List<Product>?>
            ) {
                if(response.body()!=null){
                    binding.rvAllProducts.adapter = AllProductsAdapter(requireContext(),response.body()!!,db)
                }else{
                    Toast.makeText(requireContext(), "Response is null", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                Toast.makeText(requireContext(), "Fail : $t", Toast.LENGTH_SHORT).show()
            }
        })
    }


}