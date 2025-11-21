package com.derkpy.note_ia.domain

import com.google.firebase.auth.FirebaseUser

interface DataRepository {

    suspend fun requestSing(user : String, password : String): FirebaseUser?

    fun currentUser(): FirebaseUser?

    fun logoutSession()
    
}