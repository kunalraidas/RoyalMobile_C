package com.kunalashish.royalmobilec.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kunalashish.royalmobilec.data.model.Login_Request
import com.kunalashish.royalmobilec.data.response.Simple_Response
import com.kunalashish.royalmobilec.databinding.ActivityLoginBinding
import com.kunalashish.royalmobilec.network.NetworkService
import com.kunalashish.royalmobilec.utils.Constant.user_login
import com.kunalashish.royalmobilec.utils.Constant.user_login_details
import com.kunalashish.royalmobilec.utils.Constant.user_pref
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    var customerEmail : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isLoggedIn()

        binding.btnLogin.setOnClickListener {
            validateCustomer()

        }
        binding.haventAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }
        binding.forgotPw.setOnClickListener {
            startActivity(Intent(this, Forgot_password_Activity::class.java))
        }
    }

    private fun isLoggedIn(){
        val sharedPreferences = getSharedPreferences(user_pref,Context.MODE_PRIVATE)
        customerEmail = sharedPreferences.getString(user_login_details,null)
        if (!customerEmail.isNullOrEmpty())
        {
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
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



    private fun validateCustomer() {
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        val database = NetworkService.networkInstance

        val sharedPreferences = getSharedPreferences(user_pref, Context.MODE_PRIVATE)

        val r = database.login(Login_Request(email = email, password = password))

        r.enqueue(object : Callback<Simple_Response?> {
            override fun onResponse(
                call: Call<Simple_Response?>,
                response: Response<Simple_Response?>
            ) {
                val b = response.body()

                if (b != null)
                {
                    if (b.success)
                    {
                        val s = sharedPreferences.edit()
                        s.putString(user_login_details,email)
                        s.apply()
                        Toast.makeText(this@LoginActivity,"Login successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this@LoginActivity,"Wrong Password",Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(this@LoginActivity,"Email Not Found",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Simple_Response?>, t: Throwable) {
                Toast.makeText(this@LoginActivity,t.message.toString(),Toast.LENGTH_LONG).show()
            }
        })
    }
}

