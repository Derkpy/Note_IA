package com.derkpy.note_ia.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class DataSourceImp(private val auth : FirebaseAuth
) : DataSource {

    override suspend fun signInWithGoogle(user: String, password: String): FirebaseUser? {
        return try {
            val authResult = auth.signInWithEmailAndPassword(user, password).await()
            Log.i("TAG", "signInWithGoogle: success")
            authResult.user
        } catch (e: Exception) {
            Log.e("TAG", "signInWithGoogle: failed", e)
            null
        }
    }

    override fun currentUser(): FirebaseUser? {
        return auth.currentUser
    }

    override fun logoutSession() {
        auth.signOut()
    }


}