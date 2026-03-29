package com.vnazarov.sportdatatest.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnazarov.sportdatatest.domain.model.CountryEntity
import com.vnazarov.sportdatatest.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    private val initialCountries = listOf(
        CountryEntity(name = "Germany", capital = "Berlin", region = "Europe", population = 83_510_000),
        CountryEntity(name = "United States", capital = "Washington", region = "North America", population = 342_400_000),
        CountryEntity(name = "Japan", capital = "Tokyo", region = "Asia", population = 124_000_000),
        CountryEntity(name = "Netherlands", capital = "Amsterdam", region = "Europe", population = 17_990_000),
    )

    var countries by mutableStateOf(initialCountries)
        private set

    var selectedCountry by mutableStateOf<CountryEntity?>(null)
        private set

    init {
        viewModelScope.launch {
            getCountriesUseCase().collect { loadedCountries ->
                countries += loadedCountries
            }
        }
    }

    fun selectCountry(country: CountryEntity) {
        if (selectedCountry != country) {
            selectedCountry = country
        }
    }
}
