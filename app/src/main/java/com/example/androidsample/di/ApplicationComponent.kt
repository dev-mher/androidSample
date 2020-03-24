package com.example.androidsample.di

import android.content.Context
import com.example.androidsample.BuildConfig
import com.example.androidsample.ConfigurationImpl
import com.example.androidsample.coreapiimpl.ApiComponent
import com.example.androidsample.coredataimpl.di.RepositoryComponent
import com.example.androidsample.coredi.AndroidProvider
import com.example.androidsample.coredi.ApplicationProvider
import com.example.androidsample.coredi.NetworkProvider
import com.example.androidsample.coredi.UseCaseProvider
import com.example.androidsample.coredomainimpl.di.UseCaseComponent
import com.example.androidsample.corenetworkimpl.di.NetworkComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        AndroidProvider::class,
        NetworkProvider::class
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
                androidProvider
            )
            val apiProvider = ApiComponent.build(networkProvider)
            val repositoryProvider = RepositoryComponent.build(apiProvider)
            val useCaseProvider = UseCaseComponent.build(repositoryProvider)

            return DaggerApplicationComponent.builder()
                .androidProvider(androidProvider)
                .networkProvider(networkProvider)
                .apiProvider(apiProvider)
                .repositoryProvider(repositoryProvider)
                .useCaseProvider(useCaseProvider)
                .build()
        }
    }

}