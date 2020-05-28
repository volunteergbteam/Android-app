package ru.nightgoat.volunteer.ui.main.events.my;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MyEventsFragment_MembersInjector implements MembersInjector<MyEventsFragment> {
  private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

  public MyEventsFragment_MembersInjector(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static MembersInjector<MyEventsFragment> create(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    return new MyEventsFragment_MembersInjector(viewModelFactoryProvider);}

  @Override
  public void injectMembers(MyEventsFragment instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("ru.nightgoat.volunteer.ui.main.events.my.MyEventsFragment.viewModelFactory")
  public static void injectViewModelFactory(MyEventsFragment instance,
      ViewModelProvider.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}
