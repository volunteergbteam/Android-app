package ru.nightgoat.volunteer.ui.main.account.changeEmail;

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
public final class ChangeEmailViewModel_Factory implements Factory<ChangeEmailViewModel> {
  private final Provider<Interactor> interactorProvider;

  public ChangeEmailViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public ChangeEmailViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static ChangeEmailViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new ChangeEmailViewModel_Factory(interactorProvider);
  }

  public static ChangeEmailViewModel newInstance(Interactor interactor) {
    return new ChangeEmailViewModel(interactor);
  }
}
