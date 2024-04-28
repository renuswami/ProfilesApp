package com.renu.profiles

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProfileViewModel: ViewModel() {

    var profileData = mutableStateOf(ProfileData())
    var profile = mutableStateOf(mutableListOf(ProfileData()))

    private val profileRepo = ProfileRepo()

    val firstName =  mutableStateOf("")
    val lastName =  mutableStateOf("")
    val email =   mutableStateOf("")
    val mobile = mutableStateOf("")
    val address = mutableStateOf("")

    fun setData(){
        profileRepo.setData(profileData.value)
    }

    fun getData() {
        viewModelScope.launch {
            profile.value = profileRepo.getData() as MutableList<ProfileData>
            Log.e("GETPROFILE", profile.value.toString())
        }
    }

    fun getDataByMobile() {

        viewModelScope.launch {
            profile.value = profileRepo.getDataByMobile(profileData.value.mobile)
            Log.e("GETDATABYMOBILE", profile.value.toString())
        }
    }
}