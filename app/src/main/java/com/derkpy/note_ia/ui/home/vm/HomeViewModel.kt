package com.derkpy.note_ia.ui.home.vm

import androidx.lifecycle.ViewModel
import com.derkpy.note_ia.domain.DataRepository

class HomeViewModel constructor(private val repository: DataRepository) : ViewModel(){

    fun closeSession(){


        val currentUser = repository.currentUser()

        repository.logoutSession()

    }

}