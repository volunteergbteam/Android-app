package ru.nightgoat.volunteer.ui.login.register;

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
public final class RegisterViewModel_Factory implements Factory<RegisterViewModel> {
  private final Provider<Interactor> interactorProvider;

  public RegisterViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public RegisterViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static RegisterViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new RegisterViewModel_Factory(interactorProvider);
  }

  public static RegisterViewModel newInstance(Interactor interactor) {
    return new RegisterViewModel(interactor);
  }
}
