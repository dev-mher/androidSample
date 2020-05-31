package com.example.androidsample.corepresistenceimpl.di

import com.example.androidsample.coredi.AndroidProvider
import com.example.androidsample.coredi.PersistenceProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AndroidProvider::class],
    modules = [PersistenceModule::class]
)
interface PersistenceComponent : PersistenceProvider {

    companion object {
        fun build(androidProvider: AndroidProvider): PersistenceProvider {
            return DaggerPersistenceComponent.builder()
                .androidProvider(androidProvider)
                .build()
        }
    }
}