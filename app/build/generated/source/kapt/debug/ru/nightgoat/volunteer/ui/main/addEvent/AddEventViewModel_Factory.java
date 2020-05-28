package ru.nightgoat.volunteer.ui.main.addEvent;

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
public final class AddEventViewModel_Factory implements Factory<AddEventViewModel> {
  private final Provider<Interactor> interactorProvider;

  public AddEventViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public AddEventViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static AddEventViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new AddEventViewModel_Factory(interactorProvider);
  }

  public static AddEventViewModel newInstance(Interactor interactor) {
    return new AddEventViewModel(interactor);
  }
}
