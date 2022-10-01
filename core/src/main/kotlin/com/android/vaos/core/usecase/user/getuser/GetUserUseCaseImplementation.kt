package com.android.vaos.core.usecase.user.getuser

import com.android.vaos.core.repository.UserRepository
import javax.inject.Inject

class GetUserUseCaseImplementation @Inject constructor(
    private val userRepository: UserRepository
) : GetUserUseCase {
    override fun invoke(userUUID: String) = userRepository.getUser(userUUID)
}
