package com.example.androidsample.corenetworkimpl.di

import com.example.androidsample.coredi.AndroidProvider
import com.example.androidsample.coredi.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        AndroidProvider::class
    ],
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider {

    companion object {

        fun build(
            baseUrl: String,
            networkTimeout: Long,
            connectionTimeout: Long,
            androidProvider: AndroidProvider
        ): NetworkProvider {

            val networkModule = NetworkModule(baseUrl, networkTimeout, connectionTimeout)

            return DaggerNetworkComponent.builder()
                .networkModule(networkModule)
                .androidProvider(androidProvider)
                .build()
        }
    }

}