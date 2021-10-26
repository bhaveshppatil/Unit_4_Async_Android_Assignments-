package com.masai.loginauthapp.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [LoginEntity::class], version = 1)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun getLoginDAO(): LoginDAO

    companion object {

        private var INSTANCE: LoginDatabase? = null

        fun getLoginDatabase(context: Context): LoginDatabase {
            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    LoginDatabase::class.java,
                    "login.db"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
            }
            return INSTANCE!!
        }
    }
}