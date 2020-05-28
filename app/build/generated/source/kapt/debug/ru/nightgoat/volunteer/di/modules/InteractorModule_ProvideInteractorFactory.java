package ru.nightgoat.volunteer.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.nightgoat.volunteer.domain.Interactor;
import ru.nightgoat.volunteer.domain.Repository;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class InteractorModule_ProvideInteractorFactory implements Factory<Interactor> {
  private final Provider<Repository> repositoryProvider;

  public InteractorModule_ProvideInteractorFactory(Provider<Repository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public Interactor get() {
    return provideInteractor(repositoryProvider.get());
  }

  public static InteractorModule_ProvideInteractorFactory create(
      Provider<Repository> repositoryProvider) {
    return new InteractorModule_ProvideInteractorFactory(repositoryProvider);
  }

  public static Interactor provideInteractor(Repository repository) {
    return Preconditions.checkNotNull(InteractorModule.INSTANCE.provideInteractor(repository), "Cannot return null from a non-@Nullable @Provides method");
  }
}
