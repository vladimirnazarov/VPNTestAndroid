package com.vnazarov.sportdatatest.presentation.ui.screens.main.items

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vnazarov.sportdatatest.domain.model.CountryEntity
import com.vnazarov.sportdatatest.presentation.state.ConnectionState

@Composable
fun ConnectButton(
    modifier: Modifier = Modifier,
    selectedCountry: CountryEntity?,
    state: ConnectionState,
    onClick: (Boolean) -> Unit
) {
    val text = when (state) {
        ConnectionState.Connected -> "Disconnect"
        else -> "Connect"
    }

    val enabled = selectedCountry?.let {
        state == ConnectionState.Connected || state == ConnectionState.Disconnected
    } ?: false

    Button(
        onClick = {
            onClick(state == ConnectionState.Connected)
        },
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text, style = MaterialTheme.typography.titleLarge)
    }
}