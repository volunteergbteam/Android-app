package ru.nightgoat.volunteer.ui.main.account.edit_account;

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
public final class EditAccountViewModel_Factory implements Factory<EditAccountViewModel> {
  private final Provider<Interactor> interactorProvider;

  public EditAccountViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public EditAccountViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static EditAccountViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new EditAccountViewModel_Factory(interactorProvider);
  }

  public static EditAccountViewModel newInstance(Interactor interactor) {
    return new EditAccountViewModel(interactor);
  }
}
