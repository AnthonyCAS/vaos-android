package com.android.vaos.core.di

import com.android.vaos.core.repository.UserRepository
import com.android.vaos.core.repository.UserRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsUserRepository(
        implementation: UserRepositoryImp
    ): UserRepository
}
