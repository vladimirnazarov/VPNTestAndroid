package com.vnazarov.sportdatatest.domain.repository

import com.vnazarov.sportdatatest.domain.model.CountryEntity
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    suspend fun getCountries(): Flow<List<CountryEntity>>
}