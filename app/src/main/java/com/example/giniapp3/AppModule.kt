package com.example.giniapp3

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow

class Repository(val name :String ){

    val login  =  MutableStateFlow(false)


    fun print(){
        println("in the repo")
    }



}


class AppModule() {//private  val appContext: Context
    val repo : Repository by lazy {
        Repository("amit")
    }


}