package com.renu.profiles

import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
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
            .await()
            .toObjects(ProfileData::class.java)
    }

}