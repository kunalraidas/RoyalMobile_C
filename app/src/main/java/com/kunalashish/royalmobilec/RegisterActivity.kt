package com.kunalashish.royalmobilec
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.basgeekball.awesomevalidation.utility.RegexTemplate
import com.kunalashish.royalmobilec.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

   /* AwesomeValidation  mAwesomeValidation;
    lateinit var edt_fullname: EditText
    lateinit var EdtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var EdtConfirmPassword: EditText
    lateinit var register_title: TextView
    lateinit var register_sub_title: TextView
    lateinit var have_account: TextView
    lateinit var btn_register: Button */
    //lateinit var have_account: Button
    //private lateinit var mAwesomeValidation : AwesomeValidation
    //private  lateinit var activity: Activity
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // initComponents()
       // edt_fullname = findViewById(R.id.edt_fullname)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        binding.haveAccount.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))

          /*  mAwesomeValidation = AwesomeValidation(ValidationStyle.BASIC)
            AwesomeValidation.disableAutoFocusOnFirstFailure()
            mAwesomeValidation.addValidation(activity, R.id.edt_fullname,RegexTemplate.NOT_EMPTY, R.string.err_name)
            // mAwesomeValidation.addValidation(activity, R.id.edt_tel, RegexTemplate.TELEPHONE, R.string.err_tel);
            mAwesomeValidation.addValidation(activity, R.id.EdtEmail, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email)
            //  mAwesomeValidation.addValidation(activity, R.id.edtPassword,RegexTemplate.NOT_EMPTY, R.string.err_password);
            // mAwesomeValidation.addValidation(activity, R.id.edt_height, Range.closed(0.0f, 2.72f), R.string.err_height);
            // to validate the confirmation of another field
            val regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}"
            mAwesomeValidation.addValidation(activity, R.id.edt_password, regexPassword, R.string.err_password)
            // to validate a confirmation field (don't validate any rule other than confirmation on confirmation field)
            mAwesomeValidation.addValidation(activity, R.id.EdtConfirmPassword, R.id.edt_password, R.string.err_password_confirmation)

        */

        }
    }

}