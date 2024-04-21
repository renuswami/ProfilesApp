package com.renu.profiles.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renu.profiles.profileRepository.ProfileRepo
import com.renu.profiles.profiledata.ProfileData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class DataByMobileViewModel : ViewModel() {

    var profileData = mutableStateOf(ProfileData())
    val dataByMobile = mutableStateOf( mutableListOf(ProfileData()))
    val isEmpty = MutableStateFlow(false)

    private val profileRepo = ProfileRepo()

    val mobile = mutableStateOf("")
    fun getDataByMobile() {
        isEmpty.value = true
    viewModelScope.launch {
        dataByMobile.value = profileRepo.getDataByMobile(profileData.value.mobile)
        isEmpty.value = false
        Log.e("GETDATABYMOBILE", dataByMobile.value.toString())
    }
}
}
