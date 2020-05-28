package ru.nightgoat.volunteer.ui.main.chat.list;

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
public final class ChatListViewModel_Factory implements Factory<ChatListViewModel> {
  private final Provider<Interactor> interactorProvider;

  public ChatListViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public ChatListViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static ChatListViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new ChatListViewModel_Factory(interactorProvider);
  }

  public static ChatListViewModel newInstance(Interactor interactor) {
    return new ChatListViewModel(interactor);
  }
}
