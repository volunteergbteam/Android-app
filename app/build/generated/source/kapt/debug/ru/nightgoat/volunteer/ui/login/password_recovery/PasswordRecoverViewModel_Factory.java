package ru.nightgoat.volunteer.ui.login.password_recovery;

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
public final class PasswordRecoverViewModel_Factory implements Factory<PasswordRecoverViewModel> {
  private final Provider<Interactor> interactorProvider;

  public PasswordRecoverViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public PasswordRecoverViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static PasswordRecoverViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new PasswordRecoverViewModel_Factory(interactorProvider);
  }

  public static PasswordRecoverViewModel newInstance(Interactor interactor) {
    return new PasswordRecoverViewModel(interactor);
  }
}
