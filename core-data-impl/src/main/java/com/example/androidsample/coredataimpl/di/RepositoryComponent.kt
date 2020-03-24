package com.example.androidsample.coredataimpl.di

import com.example.androidsample.coredi.ApiProvider
import com.example.androidsample.coredi.RepositoryProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    dependencies = [ApiProvider::class],
    modules = [RepositoryModule::class]
)
interface RepositoryComponent  : RepositoryProvider {

    companion object {
        fun build(apiProvider: ApiProvider): RepositoryProvider {
            return DaggerRepositoryComponent.builder()
                .apiProvider(apiProvider)
                .build()
        }
    }
}