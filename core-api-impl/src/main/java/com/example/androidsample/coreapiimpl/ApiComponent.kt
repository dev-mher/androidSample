package com.example.androidsample.coreapiimpl

import com.example.androidsample.coredi.ApiProvider
import com.example.androidsample.coredi.NetworkProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    dependencies = [NetworkProvider::class],
    modules = [ApiModule::class]
)
interface ApiComponent : ApiProvider {

    companion object {

        fun build(networkProvider: NetworkProvider): ApiProvider {
            return DaggerApiComponent.builder()
                .networkProvider(networkProvider)
                .build()
        }
    }
}