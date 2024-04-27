package com.renu.profiles

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {

    val profileData = mutableStateOf(ProfileData())
    private var profile = mutableStateListOf(ProfileData())

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
            profile = profileRepo.getData() as SnapshotStateList<ProfileData>
        }
    }

}