package com.vnazarov.sportdatatest.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnazarov.sportdatatest.presentation.state.ConnectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VPNViewModel @Inject constructor() : ViewModel() {
    var connectionState: ConnectionState by mutableStateOf(ConnectionState.Disconnected)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun connect() {
        connectionState = ConnectionState.Connecting
        viewModelScope.launch {
            try {
                delay(2000)
                connectionState = ConnectionState.Connected
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                error = e.message.toString()
            }
        }
    }

    fun disconnect() {
        connectionState = ConnectionState.Disconnected
    }
}