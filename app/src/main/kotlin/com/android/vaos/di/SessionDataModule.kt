package com.android.vaos.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SessionDataModule {

    @Singleton
    @Provides
    fun secureDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        preferencesDataStore(name = "secure-data-store").getValue(context, String::javaClass)
}
