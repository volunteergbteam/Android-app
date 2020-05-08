package ru.nightgoat.volunteer.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.nightgoat.volunteer.App
import ru.nightgoat.volunteer.di.modules.ContextModule
import ru.nightgoat.volunteer.di.modules.DataModule
import ru.nightgoat.volunteer.di.modules.InteractorModule
import ru.nightgoat.volunteer.di.modules.NetworkModule
import ru.nightgoat.weather.di.builder.ActivityBuilder
import ru.nightgoat.weather.di.builder.ViewModelBuilder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        DataModule::class,
        ContextModule::class,
        NetworkModule::class,
        InteractorModule::class,
        ActivityBuilder::class,
        ViewModelBuilder::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}
