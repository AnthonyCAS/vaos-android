package com.android.vaos.ux

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T : Any>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val eventChannel = Channel<T>(Channel.BUFFERED)
    protected val eventsFlow = eventChannel.receiveAsFlow()

    protected val isLoading = MutableStateFlow(false)

    protected fun sendEvent(event: T) = viewModelScope.launch {
        eventChannel.send(event)
    }

    protected fun launchIO(action: suspend () -> Unit) {
        viewModelScope.launch(dispatcher) { action() }
    }

    protected fun launchDefault(action: suspend () -> Unit) {
        viewModelScope.launch { action() }
    }

    override fun onCleared() {
        eventChannel.close()
        super.onCleared()
    }
}
