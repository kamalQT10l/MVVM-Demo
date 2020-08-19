package com.example.mvvmdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.helpers.ResponseStatus
import com.example.mvvmdemo.repository.Webservice

class MickyViewModel : ViewModel() {

    private lateinit var webservice: Webservice

    private lateinit var submitLiveData: MutableLiveData<ResponseStatus>

    fun init() {
        //initialize repo
        webservice = Webservice().getInstance()
        submitLiveData = MutableLiveData()
    }

    //save api call - here mostly we use Rx java code for the api calls
    fun saveUserData(name: String, age: String) {
        if (webservice.saveDataInDB(name, age)) {
            submitLiveData.value = ResponseStatus.SUCCESS
        } else {
            submitLiveData.value = ResponseStatus.SUCCESS
        }
    }

    //returns the save api response status
    fun getSaveResponse(): MutableLiveData<ResponseStatus> {
        return submitLiveData
    }

}