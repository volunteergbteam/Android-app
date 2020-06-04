package ru.nightgoat.volunteer.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.nightgoat.volunteer.data.locationRepo.LocationRepository;
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

  private final Provider<LocationRepository> locationRepositoryProvider;

  public InteractorModule_ProvideInteractorFactory(Provider<Repository> repositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider) {
    this.repositoryProvider = repositoryProvider;
    this.locationRepositoryProvider = locationRepositoryProvider;
  }

  @Override
  public Interactor get() {
    return provideInteractor(repositoryProvider.get(), locationRepositoryProvider.get());
  }

  public static InteractorModule_ProvideInteractorFactory create(
      Provider<Repository> repositoryProvider,
      Provider<LocationRepository> locationRepositoryProvider) {
    return new InteractorModule_ProvideInteractorFactory(repositoryProvider, locationRepositoryProvider);
  }

  public static Interactor provideInteractor(Repository repository,
      LocationRepository locationRepository) {
    return Preconditions.checkNotNull(InteractorModule.INSTANCE.provideInteractor(repository, locationRepository), "Cannot return null from a non-@Nullable @Provides method");
  }
}
