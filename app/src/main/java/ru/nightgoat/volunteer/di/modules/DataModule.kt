package ru.nightgoat.volunteer.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.nightgoat.volunteer.data.ApiRepositoryImpl
import ru.nightgoat.volunteer.data.db.mDao
import ru.nightgoat.volunteer.data.db.VolunteerDatabase
import ru.nightgoat.volunteer.data.firebase.FirebaseDB
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.data.network.API
import javax.inject.Named
import javax.inject.Singleton

@Module
object DataModule {

    @Provides
    @Singleton
    @Named("firebase")
    fun provideFirebaseRepository(): Repository {
        return FirebaseDB()
    }

    @Provides
    @Singleton
    @Named("api")
    fun provideApiRepository(dao: mDao, api: API): Repository {
        return ApiRepositoryImpl(dao, api)
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