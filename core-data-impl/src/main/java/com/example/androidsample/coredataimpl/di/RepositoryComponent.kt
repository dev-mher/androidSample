package com.example.androidsample.coredataimpl.di

import com.example.androidsample.coredi.ApiProvider
import com.example.androidsample.coredi.Configuration
import com.example.androidsample.coredi.PersistenceProvider
import com.example.androidsample.coredi.RepositoryProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    dependencies = [
        ApiProvider::class,
        PersistenceProvider::class,
        Configuration::class
    ],
    modules = [RepositoryModule::class]
)
interface RepositoryComponent : RepositoryProvider {

    companion object {
        fun build(
            apiProvider: ApiProvider,
            persistenceProvider: PersistenceProvider,
            configuration: Configuration
        ): RepositoryProvider {
            return DaggerRepositoryComponent.builder()
                .apiProvider(apiProvider)
                .persistenceProvider(persistenceProvider)
                .configuration(configuration)
                .build()
        }
    }
}