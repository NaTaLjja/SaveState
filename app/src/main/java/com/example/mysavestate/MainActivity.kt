package com.example.mysavestate

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity:AppCompatActivity(){
    private var counter:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        counter = findViewById(R.id.counter)
        val add:Button = findViewById(R.id.addButton)
        val sub:Button = findViewById(R.id.subButton)
        val viewModel:MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.itemLiveData.observe(this){
            count -> counter?.text = "Counter: ${count}"
        }

        add.setOnClickListener {
            viewModel.addCounter()
        }

        sub.setOnClickListener{
            viewModel.subCounter()
        }
    }
}