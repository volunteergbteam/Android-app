package ru.nightgoat.weather.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.nightgoat.volunteer.ui.main.account.AccountFragment
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventFragment
import ru.nightgoat.volunteer.ui.main.chat.chat.ChatFragment
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListFragment
import ru.nightgoat.volunteer.ui.main.edit_account.EditAccountFragment
import ru.nightgoat.volunteer.ui.main.events.EventsFragment
import ru.nightgoat.volunteer.ui.main.map.MapFragment
import ru.nightgoat.volunteer.ui.main.settings.SettingsFragment

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideAccountFragment(): AccountFragment

    @ContributesAndroidInjector
    abstract fun provideAddEventFragment(): AddEventFragment

    @ContributesAndroidInjector
    abstract fun provideChatFragment(): ChatFragment

    @ContributesAndroidInjector
    abstract fun provideChatListFragment(): ChatListFragment

    @ContributesAndroidInjector
    abstract fun provideEditAccountFragment(): EditAccountFragment

    @ContributesAndroidInjector
    abstract fun provideEventsFragment(): EventsFragment

    @ContributesAndroidInjector
    abstract fun provideMapFragment(): MapFragment

    @ContributesAndroidInjector
    abstract fun provideSettingsFragment(): SettingsFragment

}