package ru.nightgoat.volunteer.ui.main.events.my;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.nightgoat.volunteer.domain.Interactor;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MyEventsViewModel_Factory implements Factory<MyEventsViewModel> {
  private final Provider<Interactor> interactorProvider;

  public MyEventsViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public MyEventsViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static MyEventsViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new MyEventsViewModel_Factory(interactorProvider);
  }

  public static MyEventsViewModel newInstance(Interactor interactor) {
    return new MyEventsViewModel(interactor);
  }
}
