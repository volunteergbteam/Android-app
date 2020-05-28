package ru.nightgoat.volunteer.ui.main.chat.chat;

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
public final class ChatViewModel_Factory implements Factory<ChatViewModel> {
  private final Provider<Interactor> interactorProvider;

  public ChatViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public ChatViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static ChatViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new ChatViewModel_Factory(interactorProvider);
  }

  public static ChatViewModel newInstance(Interactor interactor) {
    return new ChatViewModel(interactor);
  }
}
