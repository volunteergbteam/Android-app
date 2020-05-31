package ru.nightgoat.volunteer.ui.main.map.event;

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
public final class EventViewModel_Factory implements Factory<EventViewModel> {
  private final Provider<Interactor> interactorProvider;

  public EventViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public EventViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static EventViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new EventViewModel_Factory(interactorProvider);
  }

  public static EventViewModel newInstance(Interactor interactor) {
    return new EventViewModel(interactor);
  }
}
