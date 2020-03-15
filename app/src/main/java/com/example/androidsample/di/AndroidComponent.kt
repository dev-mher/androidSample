package com.example.androidsample.di

import android.content.Context
import com.example.androidsample.coredi.AndroidProvider
import com.example.androidsample.coredi.Configuration
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AndroidComponent : AndroidProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun configurationApp(configuration: Configuration): Builder

        fun build(): AndroidComponent
    }

    companion object {

        fun build(context: Context, configuration: Configuration): AndroidProvider =
            DaggerAndroidComponent.builder()
                .context(context)
                .configurationApp(configuration)
                .build()
    }
}