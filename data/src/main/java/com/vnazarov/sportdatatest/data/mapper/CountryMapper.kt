package com.vnazarov.sportdatatest.data.mapper

import com.vnazarov.sportdatatest.data.local.CountryLocalEntity
import com.vnazarov.sportdatatest.data.model.CountryDto
import com.vnazarov.sportdatatest.domain.model.CountryEntity
import kotlin.collections.firstOrNull

fun CountryDto.toEntity(): CountryLocalEntity {
    return CountryLocalEntity(
        name = name.common,
        capital = capital.firstOrNull() ?: "",
        region = region,
        population = population
    )
}

fun CountryLocalEntity.toDomainEntity(): CountryEntity {
    return CountryEntity(
        name = name,
        capital = capital,
        region = region,
        population = population
    )
}