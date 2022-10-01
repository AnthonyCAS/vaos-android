package com.android.vaos.di

import com.android.vaos.util.preference.DataStoreManager
import com.android.vaos.util.preference.DataStoreManagerImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface AppModule {

    @Binds
    fun bindsDataStoreManager(
        implementation: DataStoreManagerImp
    ): DataStoreManager
}
