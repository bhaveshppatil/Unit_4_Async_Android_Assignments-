package com.example.mvvm_architecture_basic.Repo

import com.example.mvvm_architecture_basic.Data.Model.RoomDatabase

class MyRepository {

    //calling room database object to get the data  from room
    val roomDatabase = RoomDatabase()

    //getting data from room database
    fun getDataFromRoomDB(): String {
        return roomDatabase.getData()
    }

}