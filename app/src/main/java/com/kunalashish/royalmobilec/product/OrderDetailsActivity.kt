package com.kunalashish.royalmobilec.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kunalashish.royalmobilec.R
import com.kunalashish.royalmobilec.adapter.AllProductsAdapter
import com.kunalashish.royalmobilec.adapter.OrderDetailsAdapter
import com.kunalashish.royalmobilec.data.product.Order
import com.kunalashish.royalmobilec.databinding.ActivityOrderDetails2Binding

class OrderDetailsActivity : AppCompatActivity() {

    var order : Order? = null
    lateinit var binding : ActivityOrderDetails2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderDetails2Binding.inflate(layoutInflater)

        val o = intent.getSerializableExtra("order") as Order
        if(o!=null)
            loadData(o)
        setContentView(binding.root)


    }

    private fun loadData(o: Order) {
        binding.rvProductItemsNew.adapter = OrderDetailsAdapter(this,o.orderItems!!)
        Toast.makeText(this, "Size is : ${o.orderItems.size}", Toast.LENGTH_SHORT).show()
    }
}