package com.example.mysavestate

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MyApplication:Application() {
    private lateinit var sharedPrefs:SharedPreferences

    override fun onCreate() {
        super.onCreate()
        instance = this
        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    fun saveData(itemCount:Int){
        sharedPrefs.edit().putInt(APP_PREFERENCES_COUNTER,itemCount).apply()
    }

    fun getSavedData():Int{
        var result = 0
        if(sharedPrefs.contains(APP_PREFERENCES_COUNTER)){
            result = sharedPrefs.getInt(APP_PREFERENCES_COUNTER,0)
        }
        return result
    }

    companion object{
        private lateinit var instance:MyApplication
        fun getApp() = instance
        private var APP_PREFERENCES_COUNTER = "counter"
    }
}