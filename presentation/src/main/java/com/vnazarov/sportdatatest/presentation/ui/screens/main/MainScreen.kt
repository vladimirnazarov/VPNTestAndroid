package com.vnazarov.sportdatatest.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vnazarov.sportdatatest.domain.model.CountryEntity
import com.vnazarov.sportdatatest.presentation.state.ConnectionState
import com.vnazarov.sportdatatest.presentation.ui.screens.main.items.ConnectButton
import com.vnazarov.sportdatatest.presentation.ui.screens.main.items.ConnectionStatusCard
import com.vnazarov.sportdatatest.presentation.ui.screens.main.items.ServerSelector
import com.vnazarov.sportdatatest.presentation.viewmodel.CountriesViewModel
import com.vnazarov.sportdatatest.presentation.viewmodel.VPNViewModel

@Composable
fun MainScreen(
    vpnViewModel: VPNViewModel,
    countriesViewModel: CountriesViewModel,
) {
    MainScreen(
        state = vpnViewModel.connectionState,
        countries = countriesViewModel.countries,
        error = vpnViewModel.error,
        selectedCountry = countriesViewModel.selectedCountry,
        onConnectionButtonClick = { connected ->
            if (connected) vpnViewModel.disconnect()
            else vpnViewModel.connect()
        },
        onCountrySelected = { country ->
            if (country != countriesViewModel.selectedCountry) {
                vpnViewModel.disconnect()
                countriesViewModel.selectCountry(country)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreen(
    state: ConnectionState,
    countries: List<CountryEntity>,
    error: String?,
    selectedCountry: CountryEntity?,
    onConnectionButtonClick: (Boolean) -> Unit,
    onCountrySelected: (CountryEntity) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "VPN Connect",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ServerSelector(
                    countries = countries,
                    selectedCountry = selectedCountry,
                    onSelected = onCountrySelected
                )

                ConnectionStatusCard(state, error)
            }

            ConnectButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                selectedCountry = selectedCountry,
                state = state,
                onClick = onConnectionButtonClick
            )
        }
    }
}