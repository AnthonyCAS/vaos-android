package com.android.vaos.di

import com.android.vaos.util.preference.StoreUserSession
import com.android.vaos.util.preference.StoreUserSessionImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
interface ViewModelModule {

    @Binds
    fun bindsStoreUserSession(
        implementation: StoreUserSessionImp
    ): StoreUserSession
}
