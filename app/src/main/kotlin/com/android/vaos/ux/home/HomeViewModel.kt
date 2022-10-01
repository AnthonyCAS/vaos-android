package com.android.vaos.ux.home

import androidx.lifecycle.viewModelScope
import com.android.vaos.core.model.user.User
import com.android.vaos.core.usecase.user.getuser.GetUserUseCase
import com.android.vaos.core.utils.onError
import com.android.vaos.core.utils.onLoading
import com.android.vaos.core.utils.onSuccess
import com.android.vaos.util.ext.stateInDefault
import com.android.vaos.util.navigation.ViewModelNav
import com.android.vaos.util.navigation.ViewModelNavImpl
import com.android.vaos.util.preference.DataStoreManager
import com.android.vaos.ux.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    dataStoreManager: DataStoreManager
) : BaseViewModel<Unit>(), ViewModelNav by ViewModelNavImpl() {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val isAGuest: StateFlow<Boolean> =
        dataStoreManager.getUserUUID()
            .mapLatest { userId ->
                val userIdExists = userId.isNotEmpty()
                if (userIdExists) {
                    getUserData(userId)
                }
                !userIdExists
            }
            .stateInDefault(
                coroutineScope = viewModelScope,
                initialValue = true
            )

    private val userData: MutableStateFlow<User?> = MutableStateFlow(null)

    val homeUiState = HomeUiState(
        isLoading = isLoading,
        userData = userData,
        isAGuest = isAGuest
    )

    private fun getUserData(
        userId: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        getUserUseCase(
            userId
        ).collect { state ->
            state.onLoading {
                isLoading.value = true
            }
            state.onSuccess {
                userData.value = it
                isLoading.value = false
            }
            state.onError {
                isLoading.value = false
            }
        }
    }
}
