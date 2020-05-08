package ru.nightgoat.weather.di.builder

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.nightgoat.volunteer.di.ViewModelKey
import ru.nightgoat.volunteer.ui.login.loginFragment.LoginViewModel
import ru.nightgoat.volunteer.ui.login.password_recovery.PasswordRecoverViewModel
import ru.nightgoat.volunteer.ui.login.register.RegisterViewModel
import ru.nightgoat.volunteer.ui.main.account.AccountViewModel
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventViewModel
import ru.nightgoat.volunteer.ui.main.chat.chat.ChatViewModel
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListViewModel
import ru.nightgoat.volunteer.ui.main.edit_account.EditAccountViewModel
import ru.nightgoat.volunteer.ui.main.events.EventsViewModel
import ru.nightgoat.volunteer.ui.main.map.MapViewModel

@Module
abstract class ViewModelModule {

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Main
    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    abstract fun bindAccountViewModel(accountViewModel: AccountViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddEventViewModel::class)
    abstract fun bindAddEventViewModel(addEventViewModel: AddEventViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChatListViewModel::class)
    abstract fun bindChatListViewModel(chatListViewModel: ChatListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditAccountViewModel::class)
    abstract fun bindEditAccountViewModel(EditAccountViewModel: EditAccountViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventsViewModel::class)
    abstract fun bindEventsViewModel(eventsViewModel: EventsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    abstract fun bindMapViewModel(mapViewModel: MapViewModel): ViewModel

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Login
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PasswordRecoverViewModel::class)
    abstract fun bindPasswordRecoverViewModel(passwordRecoverViewModel: PasswordRecoverViewModel)
            : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey (RegisterViewModel::class)
    abstract fun bindRegisterViewModel (registerViewModel: RegisterViewModel): ViewModel

}