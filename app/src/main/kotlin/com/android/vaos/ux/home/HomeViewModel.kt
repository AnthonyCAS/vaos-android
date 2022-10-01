package com.android.vaos.ux.home

import androidx.lifecycle.SavedStateHandle
import com.android.vaos.core.usecase.user.getuser.GetUserUseCase
import com.android.vaos.util.EMPTY_STRING
import com.android.vaos.util.navigation.ViewModelNav
import com.android.vaos.util.navigation.ViewModelNavImpl
import com.android.vaos.util.preference.DataStoreManager
import com.android.vaos.ux.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    dataStoreManager: DataStoreManager,
    savaStateHandle: SavedStateHandle
) : BaseViewModel<Unit>(), ViewModelNav by ViewModelNavImpl() {

    private val userName = savaStateHandle.getStateFlow(
        key = HomeRoute.Arg.USER_NAME,
        initialValue = EMPTY_STRING
    )


    val homeUiState = HomeUiState(
        isLoading = isLoading,
        userName = userName,
    )
}
