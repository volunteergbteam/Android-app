package ru.nightgoat.volunteer.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.nightgoat.volunteer.di.builder.ViewModelBuilder
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class ContextModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext
}