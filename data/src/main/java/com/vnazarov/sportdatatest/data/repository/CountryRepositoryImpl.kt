package com.vnazarov.sportdatatest.data.repository

import com.vnazarov.sportdatatest.data.local.CountryDao
import com.vnazarov.sportdatatest.data.mapper.toDomainEntity
import com.vnazarov.sportdatatest.data.mapper.toEntity
import com.vnazarov.sportdatatest.data.network.ApiService
import com.vnazarov.sportdatatest.domain.model.CountryEntity
import com.vnazarov.sportdatatest.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val countryDao: CountryDao
) : CountryRepository {

    override suspend fun getCountries(): Flow<List<CountryEntity>> {
        try {
            val countries = apiService.getCountries()
            countryDao.insertCountries(countries.map { it.toEntity() })
        } catch (e: Exception) {
            // Handle error
        }

        return countryDao.getAllCountries().map { it.map { data -> data.toDomainEntity() } }
    }
}