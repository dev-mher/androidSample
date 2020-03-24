package com.example.androidsample.coredomainimpl.di

import com.example.androidsample.coredi.RepositoryProvider
import com.example.androidsample.coredi.UseCaseProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [RepositoryProvider::class],
    modules = [UseCaseModule::class]
)
interface UseCaseComponent : UseCaseProvider {

    companion object {
        fun build(repositoryProvider: RepositoryProvider): UseCaseProvider {
            return DaggerUseCaseComponent.builder()
                .repositoryProvider(repositoryProvider)
                .build()
        }
    }
}