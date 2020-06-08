package com.example.androidsample.di

import android.content.Context
import com.example.androidsample.BuildConfig
import com.example.androidsample.ConfigurationImpl
import com.example.androidsample.coreapiimpl.ApiComponent
import com.example.androidsample.coredataimpl.di.RepositoryComponent
import com.example.androidsample.coredi.*
import com.example.androidsample.coredomainimpl.di.UseCaseComponent
import com.example.androidsample.corenetworkimpl.di.NetworkComponent
import com.example.androidsample.corepresistenceimpl.di.PersistenceComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        AndroidProvider::class,
        NetworkProvider::class,
        ApiProvider::class,
        PersistenceProvider::class,
        RepositoryProvider::class,
        UseCaseProvider::class
    ]
)
interface ApplicationComponent : ApplicationProvider {

    companion object {
        fun build(context: Context): ApplicationProvider {

            val configuration = ConfigurationImpl(context)
            val androidProvider = AndroidComponent.build(context, configuration)
            val networkProvider = NetworkComponent.build(
                BuildConfig.BASE_URL,
                BuildConfig.NETWORK_TIMEOUT_MILLIS,
                BuildConfig.CONNECT_TIMEOUT_MILLIS,
                androidProvider,
                BuildConfig.DEBUG
            )
            val apiProvider = ApiComponent.build(networkProvider)
            val persistenceProvider = PersistenceComponent.build(androidProvider)
            val repositoryProvider = RepositoryComponent.build(apiProvider, persistenceProvider, configuration)
            val useCaseProvider = UseCaseComponent.build(repositoryProvider)

            return DaggerApplicationComponent.builder()
                .androidProvider(androidProvider)
                .networkProvider(networkProvider)
                .apiProvider(apiProvider)
                .persistenceProvider(persistenceProvider)
                .repositoryProvider(repositoryProvider)
                .useCaseProvider(useCaseProvider)
                .build()
        }
    }

}