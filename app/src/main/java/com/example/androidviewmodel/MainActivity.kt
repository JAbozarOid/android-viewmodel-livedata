package com.example.androidviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var data: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * this two lines means when the app rotated the data will not lose because of viewModel class
         */
        val model:MainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
//        val myRandomNumber:String = model.getNumber()
        val myRandomNumber:MutableLiveData<String> = model.getNumber()

        myRandomNumber.observe(this, Observer<String> {number ->
            tvNumber.text = number
            Log.i(TAG,"Random number set")
        })

        /**
         * this two lines that commented means when app rotated the data loses so for this problem we use ViewModel class
         */
//        data = MainActivityViewModel()
//        val myRandomNumber:String = data.getNumber()
//        tvNumber.text = myRandomNumber

        btnRandom.setOnClickListener{
            model.createNumber()
        }
    }

    companion object {
        private val TAG:String? = MainActivity::class.simpleName
    }
}
