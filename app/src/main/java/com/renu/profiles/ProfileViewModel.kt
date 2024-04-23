package com.renu.profiles

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {

    val profileData = mutableStateOf(ProfileData())
    private val profileRepo = ProfileRepo()

    fun setData(){
        profileRepo.setData(profileData.value)
    }

    fun getData(){
        viewModelScope.launch {
            profileData.value = profileRepo.getData()!!
        }
    }
}