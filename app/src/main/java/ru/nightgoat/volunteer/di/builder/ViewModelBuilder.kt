package ru.nightgoat.volunteer.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.nightgoat.volunteer.di.builder.ViewModelModule
import ru.nightgoat.volunteer.ui.ViewModelFactory

@Module(includes = [ViewModelModule::class])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory)
            : ViewModelProvider.Factory
}