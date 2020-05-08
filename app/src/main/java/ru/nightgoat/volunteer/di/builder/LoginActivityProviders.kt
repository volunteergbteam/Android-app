package ru.nightgoat.volunteer.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.nightgoat.volunteer.ui.login.loginFragment.LoginFragment
import ru.nightgoat.volunteer.ui.login.password_recovery.PasswordRecoverFragment
import ru.nightgoat.volunteer.ui.login.register.RegisterFragment

@Module
abstract class LoginActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun providePasswordRecoverFragment(): PasswordRecoverFragment

    @ContributesAndroidInjector
    abstract fun provideRegisterFragment(): RegisterFragment
}