package com.example.androidsample.corenetworkimpl.di

import android.content.Context
import com.example.androidsample.corenetworkapi.ApiClient
import com.example.androidsample.corenetworkimpl.ApiClientImpl
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Singleton
@Module
class NetworkModule(
    private val baseUrl: String,
    private val networkTimeout: Long,
    private val connectionTimeout: Long
) {
    private companion object {
        private const val HTTP_CACHE_SIZE_BYTES = 1024 * 1024 * 50L
    }

    @Singleton
    @Provides
    fun provideApiClient(
        cache: Cache
    ): ApiClient {
        val apiClient = ApiClientImpl()
        val okBuilder = apiClient.okBuilder
        okBuilder.apply {
            connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS)
            readTimeout(networkTimeout, TimeUnit.MILLISECONDS)
            writeTimeout(networkTimeout, TimeUnit.MILLISECONDS)
            retryOnConnectionFailure(true)
            followRedirects(true)
            followSslRedirects(true)
            cache(cache)
        }
        val okHttpClient = okBuilder.build()
        apiClient.adapterBuilder
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return apiClient
    }

    @Singleton
    @Provides
    fun httpCache(context: Context): Cache {
        return Cache(context.cacheDir, HTTP_CACHE_SIZE_BYTES)
    }
}