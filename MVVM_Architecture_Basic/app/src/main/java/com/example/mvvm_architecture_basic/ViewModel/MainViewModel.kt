package com.example.mvvm_architecture_basic.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_architecture_basic.Repo.MyRepository

class MainViewModel () : ViewModel() {

    //creating object of  MyRepository() to get the data
    private val myRepository = MyRepository()

    //getting the data from repo,  repo return the livedata to viewModel
    fun getDataFromRepo() : LiveData<String>{
        val mutableLiveData = MutableLiveData<String>()
        //It gets the LiveData from repo and convert that to mutableLiveData
        mutableLiveData.value = myRepository.getDataFromRoomDB()
        return mutableLiveData
    }
}