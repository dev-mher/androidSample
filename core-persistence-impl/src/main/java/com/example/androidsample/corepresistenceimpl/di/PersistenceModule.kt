package com.example.androidsample.corepresistenceimpl.di

import android.content.Context
import com.example.androidsample.corepersistenceapi.database.DatabaseManagerApi
import com.example.androidsample.corepersistenceapi.preference.PreferenceManagerApi
import com.example.androidsample.corepresistenceimpl.database.DatabaseManagerImpl
import com.example.androidsample.corepresistenceimpl.preference.PreferenceManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Singleton
    @Provides
    fun providePreferenceManagerApi(context: Context): PreferenceManagerApi = PreferenceManagerImpl(context)

    @Singleton
    @Provides
    fun provideDatabaseManagerApi(context: Context): DatabaseManagerApi = DatabaseManagerImpl.build(context)
}