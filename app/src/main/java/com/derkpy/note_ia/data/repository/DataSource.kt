package com.derkpy.note_ia.data.repository

import com.google.firebase.auth.FirebaseUser

interface DataSource {

    suspend fun signInWithGoogle(user : String, password : String): FirebaseUser?

    fun currentUser(): FirebaseUser?

    fun logoutSession()
}