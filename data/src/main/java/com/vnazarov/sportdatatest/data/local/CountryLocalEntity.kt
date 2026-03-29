package com.vnazarov.sportdatatest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryLocalEntity(
    @PrimaryKey val name: String,
    val capital: String,
    val region: String,
    val population: Int
)