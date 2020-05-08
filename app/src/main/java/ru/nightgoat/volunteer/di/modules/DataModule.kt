package ru.nightgoat.volunteer.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.nightgoat.volunteer.data.RepositoryImpl
import ru.nightgoat.volunteer.data.db.mDao
import ru.nightgoat.volunteer.data.db.VolunteerDatabase
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.data.network.API
import javax.inject.Singleton

@Module
object DataModule {

    @Provides
    @Singleton
    fun provideRepository(mDao: mDao, api: API): Repository {
        return RepositoryImpl(mDao, api)
    }

    @Provides
    @Singleton
    fun provideDao(citiesDatabase: VolunteerDatabase): mDao {
        return citiesDatabase.dao()
    }

    @Provides
    @Singleton
    fun provideDataBase(context: Context): VolunteerDatabase = VolunteerDatabase.getInstance(context)
}