package ru.nightgoat.volunteer.ui.main.events.active;

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
public final class ActiveEventsViewModel_Factory implements Factory<ActiveEventsViewModel> {
  private final Provider<Interactor> interactorProvider;

  public ActiveEventsViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public ActiveEventsViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static ActiveEventsViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new ActiveEventsViewModel_Factory(interactorProvider);
  }

  public static ActiveEventsViewModel newInstance(Interactor interactor) {
    return new ActiveEventsViewModel(interactor);
  }
}
