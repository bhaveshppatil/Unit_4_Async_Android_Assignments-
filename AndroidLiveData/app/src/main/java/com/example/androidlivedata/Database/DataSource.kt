package com.example.androidlivedata.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class DataSource {

    var incFirstFragment = 0;
    var incSecondFragment = 0;

    private val mutableFirstFragment = MutableLiveData<String>()
    private val mutableSecondFragment = MutableLiveData<String>()

    private val mediatorLiveData = MediatorLiveData<String>()

    fun incFirstFrag(){
        incFirstFragment++
        mutableFirstFragment.value = "First Fragment $incFirstFragment"
    }

    fun incSecondFrag(){
        incSecondFragment++
        mutableSecondFragment.value = "Second Fragment $incSecondFragment"
    }

    fun getMediatorLiveData() : LiveData<String> {
        mediatorLiveData.addSource(mutableFirstFragment, Observer {
            mediatorLiveData.value = it
        })
        mediatorLiveData.addSource(mutableSecondFragment, Observer {
            mediatorLiveData.value = it
        })
        return mediatorLiveData
    }
}