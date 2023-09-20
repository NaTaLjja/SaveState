package com.example.mysavestate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    private var model:Model = ModelImpl
    val itemLiveData = MutableLiveData(model.getCounter())

    init{
        if(model.getCounter() != 0)
            itemLiveData.value = model.getCounter()
    }
    fun addCounter(){
        model.addCounter()
        itemLiveData.value = model.getCounter()
        MyApplication.getApp().saveData(model.getCounter())
    }
    fun subCounter(){
        model.subCounter()
        itemLiveData.value = model.getCounter()
        MyApplication.getApp().saveData(model.getCounter())
    }
}