package com.masai.loginauthapp.ViewModel

import androidx.lifecycle.ViewModel
import com.masai.loginauthapp.Repository.LoginRepository
import com.masai.loginauthapp.RoomDatabase.LoginEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(val loginRepository: LoginRepository) : ViewModel() {

    fun addUserData(loginEntity: LoginEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            loginRepository.addUser(loginEntity)
        }
    }

    fun checkUserData(email: String, passwd: String) {
        loginRepository.checkUser(email, passwd)
    }
}