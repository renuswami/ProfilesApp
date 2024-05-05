package com.renu.profiles.profileRepository

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.renu.profiles.profiledata.ProfileData
import kotlinx.coroutines.tasks.await

class ProfileRepo {
    private val db = Firebase.firestore

    fun setData(profileData: ProfileData) {

        db.collection("Profile")
            .document(profileData.mobile)
            .set(profileData)
    }

    suspend fun getData(): List<ProfileData> {

        return db.collection("Profile")
            .get()
            .addOnSuccessListener {
                Log.e("GET", it.documents.toString())
            }
            .await()
            .toObjects(ProfileData::class.java)
    }

    suspend fun getDataByMobile(mobile: String): MutableList<ProfileData> {

        return db.collection("Profile")
            .limit(1)
            .whereEqualTo("mobile", mobile)
            .get()
            .addOnSuccessListener {
                Log.e("GETDATABYMOBILE", it.documents.toString())
            }
            .await()
            .toObjects(ProfileData::class.java)
    }
}