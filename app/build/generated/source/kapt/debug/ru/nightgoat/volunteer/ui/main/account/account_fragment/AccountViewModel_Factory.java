package ru.nightgoat.volunteer.ui.main.account.account_fragment;

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
public final class AccountViewModel_Factory implements Factory<AccountViewModel> {
  private final Provider<Interactor> interactorProvider;

  public AccountViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public AccountViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static AccountViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new AccountViewModel_Factory(interactorProvider);
  }

  public static AccountViewModel newInstance(Interactor interactor) {
    return new AccountViewModel(interactor);
  }
}
