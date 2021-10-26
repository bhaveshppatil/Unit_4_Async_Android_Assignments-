package com.masai.loginauthapp.RoomDatabase

import androidx.room.*


@Dao
interface LoginDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(loginEntity: LoginEntity)

    @Query("select * from login_table where email = :email and passwd = :passwd")
    fun getUser(email: String, passwd: String): LoginEntity

    @Update
    fun updateUser(loginEntity: LoginEntity)

    @Delete
    fun deleteUser(loginEntity: LoginEntity)

}