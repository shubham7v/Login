package com.shubham.theavengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LogInActivity : AppCompatActivity(){

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony","steve","bruce","thanos")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
         setContentView(R.layout.activity_log_in)

        if(isLoggedIn){
            val intent = Intent(this@LogInActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "LogIn"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgetPassword = findViewById(R.id.txtForgetPassword)
        txtRegister = findViewById(R.id.txtRegister)



        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            var nameOfAvengers = "Avengers"
            val intent = Intent(this@LogInActivity,MainActivity::class.java)

            if((mobileNumber == validMobileNumber)) {

                if (password == validPassword[0]) {

                    nameOfAvengers = "tony stack"
                     savepreferences(nameOfAvengers)

                    startActivity(intent)

                }else if(password==validPassword[1]){

                    nameOfAvengers = "captai amerca"
                     savepreferences(nameOfAvengers)

                    startActivity(intent)
                }
                else if(password==validPassword[2]){

                    nameOfAvengers = "the hulk"
                     savepreferences(nameOfAvengers)

                    startActivity(intent)
                }
                else if(password==validPassword[3]){

                    nameOfAvengers = "the avengers"
                     savepreferences(nameOfAvengers)   

                    startActivity(intent)
                } else{
                     Toast.makeText(this@LogInActivity,"incorrect cridential",Toast.LENGTH_LONG).show()  
                }

            }else{
                Toast.makeText(this@LogInActivity,"incorrect cridential",Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savepreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }


}