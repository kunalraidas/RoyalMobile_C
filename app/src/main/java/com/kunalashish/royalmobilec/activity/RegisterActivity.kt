package com.kunalashish.royalmobilec.activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kunalashish.royalmobilec.data.model.Register_Request
import com.kunalashish.royalmobilec.data.response.Simple_Response
import com.kunalashish.royalmobilec.databinding.ActivityRegisterBinding
import com.kunalashish.royalmobilec.network.NetworkService
import com.kunalashish.royalmobilec.utils.Constant.user_pref
import com.kunalashish.royalmobilec.utils.Constant.user_register
import com.kunalashish.royalmobilec.utils.Constant.user_register_details
import retrofit2.Response
import javax.security.auth.callback.Callback


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(this.binding.root)

        binding.btnRegister.setOnClickListener {
            registerCustomer()
        }

        binding.haveAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex(pattern = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
        return emailRegex.matches(email)
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordRegex = Regex(pattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=_!])(?=\\S+$).{8,}$")
        return passwordRegex.matches(password)
    }

    private fun registerCustomer()
    {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        val first_name = binding.edtFirstName.text.toString()
        val last_name = binding.edtLastName.text.toString()
        val phone = binding.edtPhoneNo.text.toString().toLong()
        val cust_address = binding.edtCustomerAddress.text.toString()
        val delivery_address = binding.edtDeliveryAddress.text.toString()
        val pincode = binding.edtPinCode.text.toString().toInt()

        val database = NetworkService.networkInstance

        val sharedPreferences = getSharedPreferences(user_pref, Context.MODE_PRIVATE)


        val r = database.register(
            Register_Request(
            email=email,password=password,first_name=first_name,
            last_name = last_name, phone_no = phone, cust_address = cust_address,
            delivery_address = delivery_address, pincode = pincode)
        )

        r.enqueue(object : retrofit2.Callback<Simple_Response?> {
            override fun onResponse(
                call: retrofit2.Call<Simple_Response?>,
                response: Response<Simple_Response?>
            ) {
                val b = response.body()

                if (b != null)
                {
                    if (b.success)
                    {
                        val s = sharedPreferences.edit()
                        s.putString(user_register_details,email)
                        s.apply()
                        Toast.makeText(this@RegisterActivity,"Register Successfully",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                        finish()
                    } else
                    {
                        Toast.makeText(this@RegisterActivity,"Some  Field Missing",Toast.LENGTH_LONG).show()
                    }
                } else
                {
                    Toast.makeText(this@RegisterActivity,"$b",Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: retrofit2.Call<Simple_Response?>, t: Throwable) {
                 binding.registerTitle.text = t.message.toString()
                Toast.makeText(this@RegisterActivity,t.message.toString(),Toast.LENGTH_LONG).show()
            }
        })
    }
}

