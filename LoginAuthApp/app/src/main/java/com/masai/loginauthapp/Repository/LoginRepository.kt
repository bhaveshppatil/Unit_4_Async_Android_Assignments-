package com.masai.loginauthapp.Repository

import androidx.lifecycle.LiveData
import com.masai.loginauthapp.RoomDatabase.LoginDAO
import com.masai.loginauthapp.RoomDatabase.LoginEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginRepository(val loginDAO: LoginDAO) {

    fun addUser(loginEntity: LoginEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            loginDAO.insertData(loginEntity)
        }
    }

    fun checkUser(email : String, passwd : String){
        loginDAO.getUser(email, passwd)
    }
}