package com.vnazarov.sportdatatest.data.model

data class CountryDto(
    val name: Name,
    val capital: List<String>,
    val region: String,
    val population: Int
)

data class Name(
    val common: String
)