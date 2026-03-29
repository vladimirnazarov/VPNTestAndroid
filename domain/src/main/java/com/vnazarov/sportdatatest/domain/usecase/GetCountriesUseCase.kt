package com.vnazarov.sportdatatest.domain.usecase

import com.vnazarov.sportdatatest.domain.model.CountryEntity
import com.vnazarov.sportdatatest.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    suspend operator fun invoke(): Flow<List<CountryEntity>> {
        return countryRepository.getCountries()
    }
}