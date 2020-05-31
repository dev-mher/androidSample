package com.example.androidsample.coredataimpl.di

import com.example.androidsample.coredi.ApiProvider
import com.example.androidsample.coredi.PersistenceProvider
import com.example.androidsample.coredi.RepositoryProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    dependencies = [
        ApiProvider::class,
        PersistenceProvider::class
    ],
    modules = [RepositoryModule::class]
)
interface RepositoryComponent : RepositoryProvider {

    companion object {
        fun build(
            apiProvider: ApiProvider,
            persistenceProvider: PersistenceProvider
        ): RepositoryProvider {
            return DaggerRepositoryComponent.builder()
                .apiProvider(apiProvider)
                .persistenceProvider(persistenceProvider)
                .build()
        }
    }
}