package com.example.mysavestate

object ModelImpl:Model {
    private var count = 0
    init{
        val saveCount = MyApplication.getApp().getSavedData()
        if(saveCount != 0){
            count = saveCount
        }
    }
    override fun getCounter(): Int = count

    override fun addCounter() {
        count++
    }

    override fun subCounter() {
        count--
    }
}