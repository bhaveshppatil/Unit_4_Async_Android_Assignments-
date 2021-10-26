package com.masai.loginauthapp.Views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.masai.loginauthapp.R
import com.masai.loginauthapp.Repository.LoginRepository
import com.masai.loginauthapp.RoomDatabase.LoginDAO
import com.masai.loginauthapp.RoomDatabase.LoginDatabase
import com.masai.loginauthapp.ViewModel.LoginViewModel
import com.masai.loginauthapp.ViewModel.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var loginDatabase: LoginDatabase
    private lateinit var loginDAO: LoginDAO
    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginDAO = LoginDatabase.getLoginDatabase(this).getLoginDAO()
        val loginRepository = LoginRepository(loginDAO)
        val loginViewModelFactory = LoginViewModelFactory(loginRepository)
        loginViewModel =
            ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)

        btnSingUp.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        btnSignIn.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val email = etLoginEmail.text.toString()
                val passwd = etLoginPasswd.text.toString();

                loginViewModel.checkUserData(email, passwd)

                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(
                        this@MainActivity,
                        "Login Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}