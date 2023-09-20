package com.example.mysavestate

object ModelImpl:Model {
    private var count = 0
    override fun getCounter(): Int = count

    override fun addCounter() {
        count++
    }

    override fun subCounter() {
        count--
    }
}