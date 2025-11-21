package com.derkpy.note_ia.domain

import com.derkpy.note_ia.data.repository.DataSource
import com.google.firebase.auth.FirebaseUser

class DataRepositoryImp(private val remoteData : DataSource) : DataRepository {

    override suspend fun requestSing(user: String, password: String): FirebaseUser? {
        return remoteData.signInWithGoogle(user, password)
    }

    override fun currentUser(): FirebaseUser? {
        return remoteData.currentUser()
    }

    override fun logoutSession() {
        remoteData.logoutSession()
    }

}