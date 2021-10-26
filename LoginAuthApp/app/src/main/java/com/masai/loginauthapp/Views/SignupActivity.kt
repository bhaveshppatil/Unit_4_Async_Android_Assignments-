package com.masai.loginauthapp.Views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.masai.loginauthapp.R
import com.masai.loginauthapp.Repository.LoginRepository
import com.masai.loginauthapp.RoomDatabase.LoginDAO
import com.masai.loginauthapp.RoomDatabase.LoginDatabase
import com.masai.loginauthapp.RoomDatabase.LoginEntity
import com.masai.loginauthapp.ViewModel.LoginViewModel
import com.masai.loginauthapp.ViewModel.LoginViewModelFactory
import kotlinx.android.synthetic.main.register_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    private lateinit var loginDatabase: LoginDatabase
    private lateinit var loginDAO: LoginDAO
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)


        loginDAO = LoginDatabase.getLoginDatabase(this).getLoginDAO()
        val loginRepository = LoginRepository(loginDAO)
        val loginViewModelFactory = LoginViewModelFactory(loginRepository)
        loginViewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)


        btSignUp.setOnClickListener {

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val age = etAge.text.toString().toInt()
            val passwd = etPasswd.text.toString()
            val number = etMobile.text.toString()

            val addNewUser = LoginEntity(name, email, age, passwd, number)
            loginViewModel.addUserData(addNewUser)

        }
    }
}