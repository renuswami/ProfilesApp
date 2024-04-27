package com.renu.profiles

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class ProfileRepo {
    private val db = Firebase.firestore

    fun setData(profileData: ProfileData){

        db.collection("Profile")
            .document(profileData.mobile)
            .set(profileData)
    }

    suspend fun getData(): ProfileData?{

        return db.collection("Profile")
            .document("mobile")
            .get()
            .await()
            .toObject(ProfileData::class.java)
    }
}