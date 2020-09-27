package com.example.myuserloggingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main2.*
import java.net.PasswordAuthentication
import java.security.AccessController.getContext
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        btn_2.setOnClickListener {
            val validEmail = validateEmail()
            val validPassword = validatePassword()
            // val validREPassword = valRePassword()
            if (validEmail && validPassword) {
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateEmail(): Boolean {
        //var emailAddress: TextInputEditText?
        val emailAddress = findViewById<EditText>(R.id.ed_txt_ema)
        val pattern: Pattern = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")
        val matcher: Matcher = pattern.matcher(emailAddress.text.toString().toUpperCase())
        return matcher.find()
    }


    private fun validatePassword(): Boolean {
        val pass1 = findViewById<EditText>(R.id.ed_txt_pass2)
        val pass2 = findViewById<EditText>(R.id.ed_txt_pass3)

       if (pass1.text.toString().equals(pass2.text.toString())) {
            if (pass1.text.toString().length >= 8) {
                val pattern: Pattern = Pattern.compile("^(?=.*?\\p{Lu})(?=.*?\\p{Ll})(?=.*?\\d)")
                val matcher: Matcher = pattern.matcher(pass1.text.toString())
                return matcher.find()
            }
        }

        return true
    }
}



