package com.vnazarov.sportdatatest.presentation.ui.screens.main.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vnazarov.sportdatatest.presentation.state.ConnectionState
import com.vnazarov.sportdatatest.presentation.ui.theme.greenBackgroundColor
import com.vnazarov.sportdatatest.presentation.ui.theme.greenFontColor
import com.vnazarov.sportdatatest.presentation.ui.theme.redBackgroundColor
import com.vnazarov.sportdatatest.presentation.ui.theme.redFontColor
import com.vnazarov.sportdatatest.presentation.ui.theme.yellowBackgroundColor
import com.vnazarov.sportdatatest.presentation.ui.theme.yellowFontColor

@Composable
fun ConnectionStatusCard(
    state: ConnectionState,
    error: String? = null,
) {

    val (text, backGrdColor, fontColor) = when (state) {
        ConnectionState.Disconnected -> Triple("Disconnected", redBackgroundColor, redFontColor)
        ConnectionState.Connecting -> Triple("Connecting...", yellowBackgroundColor, yellowFontColor)
        ConnectionState.Connected -> Triple("Connected", greenBackgroundColor, greenFontColor)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = backGrdColor)
    ) {
        Column {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp,
                    color = fontColor,
                    progress = { 1f }
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = text,
                    style = MaterialTheme.typography.titleMedium,
                    color = fontColor
                )
            }
        }
    }

    if (error != null) {
        Text(
            text = "Error: $error",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Red
        )
    }
}