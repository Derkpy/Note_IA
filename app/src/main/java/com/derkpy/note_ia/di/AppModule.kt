package com.derkpy.note_ia.di

import com.google.firebase.auth.FirebaseAuth
import com.derkpy.note_ia.domain.DataRepository
import com.derkpy.note_ia.domain.DataRepositoryImp
import org.koin.dsl.module

val appModule = module {

    single { FirebaseAuth.getInstance() }

    single<DataRepository> { DataRepositoryImp(get()) }

}