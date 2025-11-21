package com.derkpy.note_ia.di

import com.derkpy.note_ia.domain.DataRepository
import com.derkpy.note_ia.domain.DataRepositoryImp
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataRepositoryModule = module {
    singleOf(::DataRepositoryImp){
        bind<DataRepository>()
    }
}