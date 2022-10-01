package com.android.vaos.core.usecase.user.registeruser

import com.android.vaos.core.repository.UserRepository
import javax.inject.Inject

class RegisterUserUseCaseImplementation @Inject constructor(
    private val userRepository: UserRepository
) : RegisterUserUseCase {
    override fun invoke(userName: String) = userRepository.registerUser(userName)
}
