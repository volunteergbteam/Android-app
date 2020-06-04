package ru.nightgoat.volunteer.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.nightgoat.volunteer.di.builder.LoginActivityProviders
import ru.nightgoat.volunteer.di.builder.MainActivityProviders
import ru.nightgoat.volunteer.ui.login.LoginActivity
import ru.nightgoat.volunteer.ui.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginActivityProviders::class])
    abstract fun bindLoginActivity(): LoginActivity
}