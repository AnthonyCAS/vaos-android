package com.android.vaos.core.di

import com.android.vaos.core.usecase.user.getuser.GetUserUseCase
import com.android.vaos.core.usecase.user.getuser.GetUserUseCaseImplementation
import com.android.vaos.core.usecase.user.registeruser.RegisterUserUseCase
import com.android.vaos.core.usecase.user.registeruser.RegisterUserUseCaseImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface UserModule {

    @Binds
    fun bindsRegisterUserUseCase(
        implementation: RegisterUserUseCaseImplementation
    ): RegisterUserUseCase

    @Binds
    fun bindsGetUserUseCase(
        implementation: GetUserUseCaseImplementation
    ): GetUserUseCase
}
