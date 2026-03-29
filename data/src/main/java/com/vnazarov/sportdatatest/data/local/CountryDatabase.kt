package com.vnazarov.sportdatatest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryLocalEntity::class], version = 1)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}