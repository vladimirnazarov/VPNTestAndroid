package com.vnazarov.sportdatatest.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.vnazarov.sportdatatest.presentation.ui.screens.main.MainScreen
import com.vnazarov.sportdatatest.presentation.ui.theme.AppTheme
import com.vnazarov.sportdatatest.presentation.viewmodel.CountriesViewModel
import com.vnazarov.sportdatatest.presentation.viewmodel.VPNViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vpnViewModel: VPNViewModel by viewModels()
    private val countriesViewModel: CountriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MainScreen(
                    vpnViewModel = vpnViewModel,
                    countriesViewModel = countriesViewModel
                )
            }
        }
    }
}