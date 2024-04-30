package com.renu.profiles

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/*

class DataByMobileViewModel : ViewModel() {
fun getDataByMobile() {

    val dataByMobile = mutableStateOf( mutableListOf(ProfileData()))
    val profileRepo = ProfileRepo()

    viewModelScope.launch {
        dataByMobile.value = profileRepo.getDataByMobile(mobile)
        Log.e("GETDATABYMOBILE", dataByMobile.value.toString())
    }
}
}*/
