package com.example.androidviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel : ViewModel(){

//    private lateinit var myRandomNumber: String
      private lateinit var myRandomNumber: MutableLiveData<String>

    fun getNumber() : MutableLiveData<String> {
        Log.i(TAG,"Get Number")

        if(!::myRandomNumber.isInitialized) {
            myRandomNumber = MutableLiveData()
            this.createNumber()
        }

        return myRandomNumber
    }

    fun createNumber() {
        Log.i(TAG,"Create new number")
        val random = Random()
//        myRandomNumber = "Number: " + (random.nextInt(10 - 1) + 1)
        myRandomNumber.value = "Number: " + (random.nextInt(10 - 1) + 1)
    }

    /**
     * this method called when the app is closed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i(TAG , "ViewModel Destroyed")
    }

    companion object {
        private val TAG:String? = MainActivityViewModel::class.simpleName
    }
}