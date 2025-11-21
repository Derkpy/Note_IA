package com.derkpy.note_ia.core.navigation.authStates

sealed class AuthState {

    object Loading : AuthState()
    object LoggedIn : AuthState()
    object LoggedOut : AuthState()

}