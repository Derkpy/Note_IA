package com.derkpy.note_ia.core.navigation.vm

import androidx.lifecycle.ViewModel
import com.derkpy.note_ia.core.navigation.authStates.AuthState
import com.derkpy.note_ia.domain.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NavigationViewModel(private val repository: DataRepository) : ViewModel(){

    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    init {
        checkCurrentUser()
    }

    private fun checkCurrentUser() {
        val currentUser = repository.currentUser()
        if (currentUser != null) {
            _authState.value = AuthState.LoggedIn
        } else {
            _authState.value = AuthState.LoggedOut
        }
    }
}