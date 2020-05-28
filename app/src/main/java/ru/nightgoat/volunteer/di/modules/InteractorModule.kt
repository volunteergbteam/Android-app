package ru.nightgoat.volunteer.di.modules

import dagger.Module
import dagger.Provides
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.domain.Repository
import javax.inject.Named
import javax.inject.Singleton

@Module
object InteractorModule {

    @Provides
    @Singleton
    fun provideInteractor(@Named("firebase") repository: Repository): Interactor {
        return Interactor(repository)
    }
}