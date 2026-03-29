package com.vnazarov.sportdatatest.data.network

import com.vnazarov.sportdatatest.data.model.CountryDto
import retrofit2.http.GET

interface ApiService {

    @GET("/v3.1/all?fields=name,capital,region,population")
    suspend fun getCountries(): List<CountryDto>
}