package com.renu.profiles.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renu.profiles.profileRepository.ProfileRepo
import com.renu.profiles.profiledata.ProfileData
import kotlinx.coroutines.launch


class DataByMobileViewModel : ViewModel() {

    var profileData = mutableStateOf(ProfileData())
    val dataByMobile = mutableStateOf( mutableListOf(ProfileData()))

    private val profileRepo = ProfileRepo()

    val mobile = mutableStateOf("")
    fun getDataByMobile() {

    viewModelScope.launch {
        dataByMobile.value = profileRepo.getDataByMobile(profileData.value.mobile)
        Log.e("GETDATABYMOBILE", dataByMobile.value.toString())
    }
}
}
