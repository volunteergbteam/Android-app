package ru.nightgoat.volunteer.ui.main.map;

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
public final class MapViewModel_Factory implements Factory<MapViewModel> {
  private final Provider<Interactor> interactorProvider;

  public MapViewModel_Factory(Provider<Interactor> interactorProvider) {
    this.interactorProvider = interactorProvider;
  }

  @Override
  public MapViewModel get() {
    return newInstance(interactorProvider.get());
  }

  public static MapViewModel_Factory create(Provider<Interactor> interactorProvider) {
    return new MapViewModel_Factory(interactorProvider);
  }

  public static MapViewModel newInstance(Interactor interactor) {
    return new MapViewModel(interactor);
  }
}
