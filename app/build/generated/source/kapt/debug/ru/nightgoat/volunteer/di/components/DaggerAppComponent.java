package ru.nightgoat.volunteer.di.components;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.nightgoat.volunteer.App;
import ru.nightgoat.volunteer.di.builder.ActivityBuilder_BindLoginActivity;
import ru.nightgoat.volunteer.di.builder.ActivityBuilder_BindMainActivity;
import ru.nightgoat.volunteer.di.builder.LoginActivityProviders_ProvideLoginFragment;
import ru.nightgoat.volunteer.di.builder.LoginActivityProviders_ProvidePasswordRecoverFragment;
import ru.nightgoat.volunteer.di.builder.LoginActivityProviders_ProvideRegisterFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideAccountFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideActiveEventsFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideAddEventFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideChangeEmailFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideChangePasswordFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideChatFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideChatListFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideEditAccountFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideMapFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideMyEventsFragment;
import ru.nightgoat.volunteer.di.builder.MainActivityProviders_ProvideSettingsFragment;
import ru.nightgoat.volunteer.di.modules.DataModule_ProvideFirebaseRepositoryFactory;
import ru.nightgoat.volunteer.di.modules.InteractorModule_ProvideInteractorFactory;
import ru.nightgoat.volunteer.domain.Interactor;
import ru.nightgoat.volunteer.domain.Repository;
import ru.nightgoat.volunteer.ui.ViewModelFactory;
import ru.nightgoat.volunteer.ui.ViewModelFactory_Factory;
import ru.nightgoat.volunteer.ui.login.LoginActivity;
import ru.nightgoat.volunteer.ui.login.loginFragment.LoginFragment;
import ru.nightgoat.volunteer.ui.login.loginFragment.LoginFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.login.loginFragment.LoginViewModel;
import ru.nightgoat.volunteer.ui.login.loginFragment.LoginViewModel_Factory;
import ru.nightgoat.volunteer.ui.login.password_recovery.PasswordRecoverFragment;
import ru.nightgoat.volunteer.ui.login.password_recovery.PasswordRecoverFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.login.password_recovery.PasswordRecoverViewModel;
import ru.nightgoat.volunteer.ui.login.password_recovery.PasswordRecoverViewModel_Factory;
import ru.nightgoat.volunteer.ui.login.register.RegisterFragment;
import ru.nightgoat.volunteer.ui.login.register.RegisterFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.login.register.RegisterViewModel;
import ru.nightgoat.volunteer.ui.login.register.RegisterViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.MainActivity;
import ru.nightgoat.volunteer.ui.main.account.account_fragment.AccountFragment;
import ru.nightgoat.volunteer.ui.main.account.account_fragment.AccountFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.account.account_fragment.AccountViewModel;
import ru.nightgoat.volunteer.ui.main.account.account_fragment.AccountViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.account.changeEmail.ChangeEmailFragment;
import ru.nightgoat.volunteer.ui.main.account.changeEmail.ChangeEmailFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.account.changeEmail.ChangeEmailViewModel;
import ru.nightgoat.volunteer.ui.main.account.changeEmail.ChangeEmailViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.account.changePass.ChangePasswordFragment;
import ru.nightgoat.volunteer.ui.main.account.changePass.ChangePasswordFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.account.changePass.ChangePasswordViewModel;
import ru.nightgoat.volunteer.ui.main.account.changePass.ChangePasswordViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.account.edit_account.EditAccountFragment;
import ru.nightgoat.volunteer.ui.main.account.edit_account.EditAccountFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.account.edit_account.EditAccountViewModel;
import ru.nightgoat.volunteer.ui.main.account.edit_account.EditAccountViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventFragment;
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventViewModel;
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.chat.chat.ChatFragment;
import ru.nightgoat.volunteer.ui.main.chat.chat.ChatFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListFragment;
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListViewModel;
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.events.active.ActiveEventsFragment;
import ru.nightgoat.volunteer.ui.main.events.active.ActiveEventsFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.events.active.ActiveEventsViewModel;
import ru.nightgoat.volunteer.ui.main.events.active.ActiveEventsViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.events.my.MyEventsFragment;
import ru.nightgoat.volunteer.ui.main.events.my.MyEventsFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.events.my.MyEventsViewModel;
import ru.nightgoat.volunteer.ui.main.events.my.MyEventsViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.map.MapFragment;
import ru.nightgoat.volunteer.ui.main.map.MapFragment_MembersInjector;
import ru.nightgoat.volunteer.ui.main.map.MapViewModel;
import ru.nightgoat.volunteer.ui.main.map.MapViewModel_Factory;
import ru.nightgoat.volunteer.ui.main.settings.SettingsFragment;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private Provider<ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory> mainActivitySubcomponentFactoryProvider;

  private Provider<ActivityBuilder_BindLoginActivity.LoginActivitySubcomponent.Factory> loginActivitySubcomponentFactoryProvider;

  private Provider<Repository> provideFirebaseRepositoryProvider;

  private Provider<Interactor> provideInteractorProvider;

  private Provider<AccountViewModel> accountViewModelProvider;

  private Provider<EditAccountViewModel> editAccountViewModelProvider;

  private Provider<ChangeEmailViewModel> changeEmailViewModelProvider;

  private Provider<ChangePasswordViewModel> changePasswordViewModelProvider;

  private Provider<AddEventViewModel> addEventViewModelProvider;

  private Provider<ChatListViewModel> chatListViewModelProvider;

  private Provider<ActiveEventsViewModel> activeEventsViewModelProvider;

  private Provider<MyEventsViewModel> myEventsViewModelProvider;

  private Provider<MapViewModel> mapViewModelProvider;

  private Provider<LoginViewModel> loginViewModelProvider;

  private Provider<PasswordRecoverViewModel> passwordRecoverViewModelProvider;

  private Provider<RegisterViewModel> registerViewModelProvider;

  private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> mapOfClassOfAndProviderOfViewModelProvider;

  private Provider<ViewModelFactory> viewModelFactoryProvider;

  private DaggerAppComponent(Application application) {

    initialize(application);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
      ) {
    return MapBuilder.<Class<?>, Provider<AndroidInjector.Factory<?>>>newMapBuilder(2).put(MainActivity.class, (Provider) mainActivitySubcomponentFactoryProvider).put(LoginActivity.class, (Provider) loginActivitySubcomponentFactoryProvider).build();}

  private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
    return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

  @SuppressWarnings("unchecked")
  private void initialize(final Application application) {
    this.mainActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory>() {
      @Override
      public ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory get() {
        return new MainActivitySubcomponentFactory();}
    };
    this.loginActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_BindLoginActivity.LoginActivitySubcomponent.Factory>() {
      @Override
      public ActivityBuilder_BindLoginActivity.LoginActivitySubcomponent.Factory get() {
        return new LoginActivitySubcomponentFactory();}
    };
    this.provideFirebaseRepositoryProvider = DoubleCheck.provider(DataModule_ProvideFirebaseRepositoryFactory.create());
    this.provideInteractorProvider = DoubleCheck.provider(InteractorModule_ProvideInteractorFactory.create(provideFirebaseRepositoryProvider));
    this.accountViewModelProvider = AccountViewModel_Factory.create(provideInteractorProvider);
    this.editAccountViewModelProvider = EditAccountViewModel_Factory.create(provideInteractorProvider);
    this.changeEmailViewModelProvider = ChangeEmailViewModel_Factory.create(provideInteractorProvider);
    this.changePasswordViewModelProvider = ChangePasswordViewModel_Factory.create(provideInteractorProvider);
    this.addEventViewModelProvider = AddEventViewModel_Factory.create(provideInteractorProvider);
    this.chatListViewModelProvider = ChatListViewModel_Factory.create(provideInteractorProvider);
    this.activeEventsViewModelProvider = ActiveEventsViewModel_Factory.create(provideInteractorProvider);
    this.myEventsViewModelProvider = MyEventsViewModel_Factory.create(provideInteractorProvider);
    this.mapViewModelProvider = MapViewModel_Factory.create(provideInteractorProvider);
    this.loginViewModelProvider = LoginViewModel_Factory.create(provideInteractorProvider);
    this.passwordRecoverViewModelProvider = PasswordRecoverViewModel_Factory.create(provideInteractorProvider);
    this.registerViewModelProvider = RegisterViewModel_Factory.create(provideInteractorProvider);
    this.mapOfClassOfAndProviderOfViewModelProvider = MapProviderFactory.<Class<? extends ViewModel>, ViewModel>builder(12).put(AccountViewModel.class, (Provider) accountViewModelProvider).put(EditAccountViewModel.class, (Provider) editAccountViewModelProvider).put(ChangeEmailViewModel.class, (Provider) changeEmailViewModelProvider).put(ChangePasswordViewModel.class, (Provider) changePasswordViewModelProvider).put(AddEventViewModel.class, (Provider) addEventViewModelProvider).put(ChatListViewModel.class, (Provider) chatListViewModelProvider).put(ActiveEventsViewModel.class, (Provider) activeEventsViewModelProvider).put(MyEventsViewModel.class, (Provider) myEventsViewModelProvider).put(MapViewModel.class, (Provider) mapViewModelProvider).put(LoginViewModel.class, (Provider) loginViewModelProvider).put(PasswordRecoverViewModel.class, (Provider) passwordRecoverViewModelProvider).put(RegisterViewModel.class, (Provider) registerViewModelProvider).build();
    this.viewModelFactoryProvider = DoubleCheck.provider(ViewModelFactory_Factory.create(mapOfClassOfAndProviderOfViewModelProvider));
  }

  @Override
  public void inject(App arg0) {
    injectApp(arg0);}

  private App injectApp(App instance) {
    DaggerApplication_MembersInjector.injectAndroidInjector(instance, getDispatchingAndroidInjectorOfObject());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerAppComponent(application);
    }
  }

  private final class MainActivitySubcomponentFactory implements ActivityBuilder_BindMainActivity.MainActivitySubcomponent.Factory {
    @Override
    public ActivityBuilder_BindMainActivity.MainActivitySubcomponent create(MainActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new MainActivitySubcomponentImpl(arg0);
    }
  }

  private final class MainActivitySubcomponentImpl implements ActivityBuilder_BindMainActivity.MainActivitySubcomponent {
    private Provider<MainActivityProviders_ProvideAccountFragment.AccountFragmentSubcomponent.Factory> accountFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideEditAccountFragment.EditAccountFragmentSubcomponent.Factory> editAccountFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideChangeEmailFragment.ChangeEmailFragmentSubcomponent.Factory> changeEmailFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideChangePasswordFragment.ChangePasswordFragmentSubcomponent.Factory> changePasswordFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideAddEventFragment.AddEventFragmentSubcomponent.Factory> addEventFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideChatFragment.ChatFragmentSubcomponent.Factory> chatFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideChatListFragment.ChatListFragmentSubcomponent.Factory> chatListFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideActiveEventsFragment.ActiveEventsFragmentSubcomponent.Factory> activeEventsFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideMyEventsFragment.MyEventsFragmentSubcomponent.Factory> myEventsFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideMapFragment.MapFragmentSubcomponent.Factory> mapFragmentSubcomponentFactoryProvider;

    private Provider<MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory> settingsFragmentSubcomponentFactoryProvider;

    private MainActivitySubcomponentImpl(MainActivity arg0) {

      initialize(arg0);
    }

    private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
        ) {
      return MapBuilder.<Class<?>, Provider<AndroidInjector.Factory<?>>>newMapBuilder(13).put(MainActivity.class, (Provider) DaggerAppComponent.this.mainActivitySubcomponentFactoryProvider).put(LoginActivity.class, (Provider) DaggerAppComponent.this.loginActivitySubcomponentFactoryProvider).put(AccountFragment.class, (Provider) accountFragmentSubcomponentFactoryProvider).put(EditAccountFragment.class, (Provider) editAccountFragmentSubcomponentFactoryProvider).put(ChangeEmailFragment.class, (Provider) changeEmailFragmentSubcomponentFactoryProvider).put(ChangePasswordFragment.class, (Provider) changePasswordFragmentSubcomponentFactoryProvider).put(AddEventFragment.class, (Provider) addEventFragmentSubcomponentFactoryProvider).put(ChatFragment.class, (Provider) chatFragmentSubcomponentFactoryProvider).put(ChatListFragment.class, (Provider) chatListFragmentSubcomponentFactoryProvider).put(ActiveEventsFragment.class, (Provider) activeEventsFragmentSubcomponentFactoryProvider).put(MyEventsFragment.class, (Provider) myEventsFragmentSubcomponentFactoryProvider).put(MapFragment.class, (Provider) mapFragmentSubcomponentFactoryProvider).put(SettingsFragment.class, (Provider) settingsFragmentSubcomponentFactoryProvider).build();}

    private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
      return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

    @SuppressWarnings("unchecked")
    private void initialize(final MainActivity arg0) {
      this.accountFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideAccountFragment.AccountFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideAccountFragment.AccountFragmentSubcomponent.Factory get(
            ) {
          return new AccountFragmentSubcomponentFactory();}
      };
      this.editAccountFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideEditAccountFragment.EditAccountFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideEditAccountFragment.EditAccountFragmentSubcomponent.Factory get(
            ) {
          return new EditAccountFragmentSubcomponentFactory();}
      };
      this.changeEmailFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideChangeEmailFragment.ChangeEmailFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideChangeEmailFragment.ChangeEmailFragmentSubcomponent.Factory get(
            ) {
          return new ChangeEmailFragmentSubcomponentFactory();}
      };
      this.changePasswordFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideChangePasswordFragment.ChangePasswordFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideChangePasswordFragment.ChangePasswordFragmentSubcomponent.Factory get(
            ) {
          return new ChangePasswordFragmentSubcomponentFactory();}
      };
      this.addEventFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideAddEventFragment.AddEventFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideAddEventFragment.AddEventFragmentSubcomponent.Factory get(
            ) {
          return new AddEventFragmentSubcomponentFactory();}
      };
      this.chatFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideChatFragment.ChatFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideChatFragment.ChatFragmentSubcomponent.Factory get() {
          return new ChatFragmentSubcomponentFactory();}
      };
      this.chatListFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideChatListFragment.ChatListFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideChatListFragment.ChatListFragmentSubcomponent.Factory get(
            ) {
          return new ChatListFragmentSubcomponentFactory();}
      };
      this.activeEventsFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideActiveEventsFragment.ActiveEventsFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideActiveEventsFragment.ActiveEventsFragmentSubcomponent.Factory get(
            ) {
          return new ActiveEventsFragmentSubcomponentFactory();}
      };
      this.myEventsFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideMyEventsFragment.MyEventsFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideMyEventsFragment.MyEventsFragmentSubcomponent.Factory get(
            ) {
          return new MyEventsFragmentSubcomponentFactory();}
      };
      this.mapFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideMapFragment.MapFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideMapFragment.MapFragmentSubcomponent.Factory get() {
          return new MapFragmentSubcomponentFactory();}
      };
      this.settingsFragmentSubcomponentFactoryProvider = new Provider<MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory>() {
        @Override
        public MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory get(
            ) {
          return new SettingsFragmentSubcomponentFactory();}
      };
    }

    @Override
    public void inject(MainActivity arg0) {
      injectMainActivity(arg0);}

    private MainActivity injectMainActivity(MainActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(instance, getDispatchingAndroidInjectorOfObject());
      return instance;
    }

    private final class AccountFragmentSubcomponentFactory implements MainActivityProviders_ProvideAccountFragment.AccountFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideAccountFragment.AccountFragmentSubcomponent create(
          AccountFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new AccountFragmentSubcomponentImpl(arg0);
      }
    }

    private final class AccountFragmentSubcomponentImpl implements MainActivityProviders_ProvideAccountFragment.AccountFragmentSubcomponent {
      private AccountFragmentSubcomponentImpl(AccountFragment arg0) {

      }

      @Override
      public void inject(AccountFragment arg0) {
        injectAccountFragment(arg0);}

      private AccountFragment injectAccountFragment(AccountFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        AccountFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class EditAccountFragmentSubcomponentFactory implements MainActivityProviders_ProvideEditAccountFragment.EditAccountFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideEditAccountFragment.EditAccountFragmentSubcomponent create(
          EditAccountFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new EditAccountFragmentSubcomponentImpl(arg0);
      }
    }

    private final class EditAccountFragmentSubcomponentImpl implements MainActivityProviders_ProvideEditAccountFragment.EditAccountFragmentSubcomponent {
      private EditAccountFragmentSubcomponentImpl(EditAccountFragment arg0) {

      }

      @Override
      public void inject(EditAccountFragment arg0) {
        injectEditAccountFragment(arg0);}

      private EditAccountFragment injectEditAccountFragment(EditAccountFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        EditAccountFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class ChangeEmailFragmentSubcomponentFactory implements MainActivityProviders_ProvideChangeEmailFragment.ChangeEmailFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideChangeEmailFragment.ChangeEmailFragmentSubcomponent create(
          ChangeEmailFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new ChangeEmailFragmentSubcomponentImpl(arg0);
      }
    }

    private final class ChangeEmailFragmentSubcomponentImpl implements MainActivityProviders_ProvideChangeEmailFragment.ChangeEmailFragmentSubcomponent {
      private ChangeEmailFragmentSubcomponentImpl(ChangeEmailFragment arg0) {

      }

      @Override
      public void inject(ChangeEmailFragment arg0) {
        injectChangeEmailFragment(arg0);}

      private ChangeEmailFragment injectChangeEmailFragment(ChangeEmailFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        ChangeEmailFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class ChangePasswordFragmentSubcomponentFactory implements MainActivityProviders_ProvideChangePasswordFragment.ChangePasswordFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideChangePasswordFragment.ChangePasswordFragmentSubcomponent create(
          ChangePasswordFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new ChangePasswordFragmentSubcomponentImpl(arg0);
      }
    }

    private final class ChangePasswordFragmentSubcomponentImpl implements MainActivityProviders_ProvideChangePasswordFragment.ChangePasswordFragmentSubcomponent {
      private ChangePasswordFragmentSubcomponentImpl(ChangePasswordFragment arg0) {

      }

      @Override
      public void inject(ChangePasswordFragment arg0) {
        injectChangePasswordFragment(arg0);}

      private ChangePasswordFragment injectChangePasswordFragment(ChangePasswordFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        ChangePasswordFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class AddEventFragmentSubcomponentFactory implements MainActivityProviders_ProvideAddEventFragment.AddEventFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideAddEventFragment.AddEventFragmentSubcomponent create(
          AddEventFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new AddEventFragmentSubcomponentImpl(arg0);
      }
    }

    private final class AddEventFragmentSubcomponentImpl implements MainActivityProviders_ProvideAddEventFragment.AddEventFragmentSubcomponent {
      private AddEventFragmentSubcomponentImpl(AddEventFragment arg0) {

      }

      @Override
      public void inject(AddEventFragment arg0) {
        injectAddEventFragment(arg0);}

      private AddEventFragment injectAddEventFragment(AddEventFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        AddEventFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class ChatFragmentSubcomponentFactory implements MainActivityProviders_ProvideChatFragment.ChatFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideChatFragment.ChatFragmentSubcomponent create(
          ChatFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new ChatFragmentSubcomponentImpl(arg0);
      }
    }

    private final class ChatFragmentSubcomponentImpl implements MainActivityProviders_ProvideChatFragment.ChatFragmentSubcomponent {
      private ChatFragmentSubcomponentImpl(ChatFragment arg0) {

      }

      @Override
      public void inject(ChatFragment arg0) {
        injectChatFragment(arg0);}

      private ChatFragment injectChatFragment(ChatFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        ChatFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class ChatListFragmentSubcomponentFactory implements MainActivityProviders_ProvideChatListFragment.ChatListFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideChatListFragment.ChatListFragmentSubcomponent create(
          ChatListFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new ChatListFragmentSubcomponentImpl(arg0);
      }
    }

    private final class ChatListFragmentSubcomponentImpl implements MainActivityProviders_ProvideChatListFragment.ChatListFragmentSubcomponent {
      private ChatListFragmentSubcomponentImpl(ChatListFragment arg0) {

      }

      @Override
      public void inject(ChatListFragment arg0) {
        injectChatListFragment(arg0);}

      private ChatListFragment injectChatListFragment(ChatListFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        ChatListFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class ActiveEventsFragmentSubcomponentFactory implements MainActivityProviders_ProvideActiveEventsFragment.ActiveEventsFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideActiveEventsFragment.ActiveEventsFragmentSubcomponent create(
          ActiveEventsFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new ActiveEventsFragmentSubcomponentImpl(arg0);
      }
    }

    private final class ActiveEventsFragmentSubcomponentImpl implements MainActivityProviders_ProvideActiveEventsFragment.ActiveEventsFragmentSubcomponent {
      private ActiveEventsFragmentSubcomponentImpl(ActiveEventsFragment arg0) {

      }

      @Override
      public void inject(ActiveEventsFragment arg0) {
        injectActiveEventsFragment(arg0);}

      private ActiveEventsFragment injectActiveEventsFragment(ActiveEventsFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        ActiveEventsFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class MyEventsFragmentSubcomponentFactory implements MainActivityProviders_ProvideMyEventsFragment.MyEventsFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideMyEventsFragment.MyEventsFragmentSubcomponent create(
          MyEventsFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new MyEventsFragmentSubcomponentImpl(arg0);
      }
    }

    private final class MyEventsFragmentSubcomponentImpl implements MainActivityProviders_ProvideMyEventsFragment.MyEventsFragmentSubcomponent {
      private MyEventsFragmentSubcomponentImpl(MyEventsFragment arg0) {

      }

      @Override
      public void inject(MyEventsFragment arg0) {
        injectMyEventsFragment(arg0);}

      private MyEventsFragment injectMyEventsFragment(MyEventsFragment instance) {
        MyEventsFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class MapFragmentSubcomponentFactory implements MainActivityProviders_ProvideMapFragment.MapFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideMapFragment.MapFragmentSubcomponent create(
          MapFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new MapFragmentSubcomponentImpl(arg0);
      }
    }

    private final class MapFragmentSubcomponentImpl implements MainActivityProviders_ProvideMapFragment.MapFragmentSubcomponent {
      private MapFragmentSubcomponentImpl(MapFragment arg0) {

      }

      @Override
      public void inject(MapFragment arg0) {
        injectMapFragment(arg0);}

      private MapFragment injectMapFragment(MapFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, MainActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        MapFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class SettingsFragmentSubcomponentFactory implements MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.Factory {
      @Override
      public MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent create(
          SettingsFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new SettingsFragmentSubcomponentImpl(arg0);
      }
    }

    private final class SettingsFragmentSubcomponentImpl implements MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent {
      private SettingsFragmentSubcomponentImpl(SettingsFragment arg0) {

      }

      @Override
      public void inject(SettingsFragment arg0) {
      }
    }
  }

  private final class LoginActivitySubcomponentFactory implements ActivityBuilder_BindLoginActivity.LoginActivitySubcomponent.Factory {
    @Override
    public ActivityBuilder_BindLoginActivity.LoginActivitySubcomponent create(LoginActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new LoginActivitySubcomponentImpl(arg0);
    }
  }

  private final class LoginActivitySubcomponentImpl implements ActivityBuilder_BindLoginActivity.LoginActivitySubcomponent {
    private Provider<LoginActivityProviders_ProvideLoginFragment.LoginFragmentSubcomponent.Factory> loginFragmentSubcomponentFactoryProvider;

    private Provider<LoginActivityProviders_ProvidePasswordRecoverFragment.PasswordRecoverFragmentSubcomponent.Factory> passwordRecoverFragmentSubcomponentFactoryProvider;

    private Provider<LoginActivityProviders_ProvideRegisterFragment.RegisterFragmentSubcomponent.Factory> registerFragmentSubcomponentFactoryProvider;

    private LoginActivitySubcomponentImpl(LoginActivity arg0) {

      initialize(arg0);
    }

    private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(
        ) {
      return MapBuilder.<Class<?>, Provider<AndroidInjector.Factory<?>>>newMapBuilder(5).put(MainActivity.class, (Provider) DaggerAppComponent.this.mainActivitySubcomponentFactoryProvider).put(LoginActivity.class, (Provider) DaggerAppComponent.this.loginActivitySubcomponentFactoryProvider).put(LoginFragment.class, (Provider) loginFragmentSubcomponentFactoryProvider).put(PasswordRecoverFragment.class, (Provider) passwordRecoverFragmentSubcomponentFactoryProvider).put(RegisterFragment.class, (Provider) registerFragmentSubcomponentFactoryProvider).build();}

    private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
      return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());}

    @SuppressWarnings("unchecked")
    private void initialize(final LoginActivity arg0) {
      this.loginFragmentSubcomponentFactoryProvider = new Provider<LoginActivityProviders_ProvideLoginFragment.LoginFragmentSubcomponent.Factory>() {
        @Override
        public LoginActivityProviders_ProvideLoginFragment.LoginFragmentSubcomponent.Factory get() {
          return new LoginFragmentSubcomponentFactory();}
      };
      this.passwordRecoverFragmentSubcomponentFactoryProvider = new Provider<LoginActivityProviders_ProvidePasswordRecoverFragment.PasswordRecoverFragmentSubcomponent.Factory>() {
        @Override
        public LoginActivityProviders_ProvidePasswordRecoverFragment.PasswordRecoverFragmentSubcomponent.Factory get(
            ) {
          return new PasswordRecoverFragmentSubcomponentFactory();}
      };
      this.registerFragmentSubcomponentFactoryProvider = new Provider<LoginActivityProviders_ProvideRegisterFragment.RegisterFragmentSubcomponent.Factory>() {
        @Override
        public LoginActivityProviders_ProvideRegisterFragment.RegisterFragmentSubcomponent.Factory get(
            ) {
          return new RegisterFragmentSubcomponentFactory();}
      };
    }

    @Override
    public void inject(LoginActivity arg0) {
      injectLoginActivity(arg0);}

    private LoginActivity injectLoginActivity(LoginActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(instance, getDispatchingAndroidInjectorOfObject());
      return instance;
    }

    private final class LoginFragmentSubcomponentFactory implements LoginActivityProviders_ProvideLoginFragment.LoginFragmentSubcomponent.Factory {
      @Override
      public LoginActivityProviders_ProvideLoginFragment.LoginFragmentSubcomponent create(
          LoginFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new LoginFragmentSubcomponentImpl(arg0);
      }
    }

    private final class LoginFragmentSubcomponentImpl implements LoginActivityProviders_ProvideLoginFragment.LoginFragmentSubcomponent {
      private LoginFragmentSubcomponentImpl(LoginFragment arg0) {

      }

      @Override
      public void inject(LoginFragment arg0) {
        injectLoginFragment(arg0);}

      private LoginFragment injectLoginFragment(LoginFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, LoginActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        LoginFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class PasswordRecoverFragmentSubcomponentFactory implements LoginActivityProviders_ProvidePasswordRecoverFragment.PasswordRecoverFragmentSubcomponent.Factory {
      @Override
      public LoginActivityProviders_ProvidePasswordRecoverFragment.PasswordRecoverFragmentSubcomponent create(
          PasswordRecoverFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new PasswordRecoverFragmentSubcomponentImpl(arg0);
      }
    }

    private final class PasswordRecoverFragmentSubcomponentImpl implements LoginActivityProviders_ProvidePasswordRecoverFragment.PasswordRecoverFragmentSubcomponent {
      private PasswordRecoverFragmentSubcomponentImpl(PasswordRecoverFragment arg0) {

      }

      @Override
      public void inject(PasswordRecoverFragment arg0) {
        injectPasswordRecoverFragment(arg0);}

      private PasswordRecoverFragment injectPasswordRecoverFragment(
          PasswordRecoverFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, LoginActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        PasswordRecoverFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }

    private final class RegisterFragmentSubcomponentFactory implements LoginActivityProviders_ProvideRegisterFragment.RegisterFragmentSubcomponent.Factory {
      @Override
      public LoginActivityProviders_ProvideRegisterFragment.RegisterFragmentSubcomponent create(
          RegisterFragment arg0) {
        Preconditions.checkNotNull(arg0);
        return new RegisterFragmentSubcomponentImpl(arg0);
      }
    }

    private final class RegisterFragmentSubcomponentImpl implements LoginActivityProviders_ProvideRegisterFragment.RegisterFragmentSubcomponent {
      private RegisterFragmentSubcomponentImpl(RegisterFragment arg0) {

      }

      @Override
      public void inject(RegisterFragment arg0) {
        injectRegisterFragment(arg0);}

      private RegisterFragment injectRegisterFragment(RegisterFragment instance) {
        DaggerFragment_MembersInjector.injectAndroidInjector(instance, LoginActivitySubcomponentImpl.this.getDispatchingAndroidInjectorOfObject());
        RegisterFragment_MembersInjector.injectViewModelFactory(instance, DaggerAppComponent.this.viewModelFactoryProvider.get());
        return instance;
      }
    }
  }
}
