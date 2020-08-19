package com.example.mvvmdemo.repository

class Webservice {
    private var repositoryImpl: Webservice? = null

    fun getInstance(): Webservice {
        if (repositoryImpl == null) {
            repositoryImpl = Webservice()
        }
        return repositoryImpl as Webservice;
    }

    //this method is like retrofit post webservice call
    fun saveDataInDB(name: String, age: String): Boolean {
        return true;
    }
}