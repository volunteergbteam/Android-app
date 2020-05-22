package ru.nightgoat.weather.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.nightgoat.volunteer.ui.main.account.account_fragment.AccountFragment
import ru.nightgoat.volunteer.ui.main.account.changeEmail.ChangeEmailFragment
import ru.nightgoat.volunteer.ui.main.account.changePass.ChangePasswordFragment
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventFragment
import ru.nightgoat.volunteer.ui.main.chat.chat.ChatFragment
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListFragment
import ru.nightgoat.volunteer.ui.main.account.edit_account.EditAccountFragment
import ru.nightgoat.volunteer.ui.main.events.active.ActiveEventsFragment
import ru.nightgoat.volunteer.ui.main.events.my.MyEventsFragment
import ru.nightgoat.volunteer.ui.main.map.MapFragment
import ru.nightgoat.volunteer.ui.main.settings.SettingsFragment

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideAccountFragment(): AccountFragment

    @ContributesAndroidInjector
    abstract fun provideEditAccountFragment(): EditAccountFragment

    @ContributesAndroidInjector
    abstract fun provideChangeEmailFragment(): ChangeEmailFragment

    @ContributesAndroidInjector
    abstract fun provideChangePasswordFragment(): ChangePasswordFragment

    @ContributesAndroidInjector
    abstract fun provideAddEventFragment(): AddEventFragment

    @ContributesAndroidInjector
    abstract fun provideChatFragment(): ChatFragment

    @ContributesAndroidInjector
    abstract fun provideChatListFragment(): ChatListFragment

    @ContributesAndroidInjector
    abstract fun provideActiveEventsFragment(): ActiveEventsFragment

    @ContributesAndroidInjector
    abstract fun provideMyEventsFragment(): MyEventsFragment

    @ContributesAndroidInjector
    abstract fun provideMapFragment(): MapFragment

    @ContributesAndroidInjector
    abstract fun provideSettingsFragment(): SettingsFragment

}