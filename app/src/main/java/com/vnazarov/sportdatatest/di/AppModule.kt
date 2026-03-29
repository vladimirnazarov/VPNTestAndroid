package com.vnazarov.sportdatatest.di

import android.app.Application
import androidx.room.Room
import com.vnazarov.sportdatatest.data.local.CountryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.vnazarov.sportdatatest.data.local.CountryDatabase
import com.vnazarov.sportdatatest.data.network.ApiService
import com.vnazarov.sportdatatest.data.network.RetrofitClient
import com.vnazarov.sportdatatest.data.repository.CountryRepositoryImpl
import com.vnazarov.sportdatatest.domain.repository.CountryRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitClient.apiService
    }

    @Provides
    @Singleton
    fun provideCountryRepository(
        apiService: ApiService,
        countryDao: CountryDao
    ): CountryRepository {
        return CountryRepositoryImpl(apiService, countryDao)
    }

    @Provides
    @Singleton
    fun provideCountryDatabase(app: Application): CountryDatabase  {
        return Room.databaseBuilder(
            app,
            CountryDatabase::class.java,
            "country_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCountryDao(database: CountryDatabase): CountryDao {
        return database.countryDao()
    }
}
