package ru.nightgoat.volunteer.ui.login.loginFragment;

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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<Interactor> interactorProvider;

  public LoginViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new LoginViewModel_Factory(interactorProvider);
  }

  public static LoginViewModel newInstance(Interactor interactor) {
    return new LoginViewModel(interactor);
  }
}
