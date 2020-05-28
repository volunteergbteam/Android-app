package ru.nightgoat.volunteer.ui.main.account.changePass;

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
public final class ChangePasswordViewModel_Factory implements Factory<ChangePasswordViewModel> {
  private final Provider<Interactor> interactorProvider;

  public ChangePasswordViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public ChangePasswordViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static ChangePasswordViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new ChangePasswordViewModel_Factory(interactorProvider);
  }

  public static ChangePasswordViewModel newInstance(Interactor interactor) {
    return new ChangePasswordViewModel(interactor);
  }
}
