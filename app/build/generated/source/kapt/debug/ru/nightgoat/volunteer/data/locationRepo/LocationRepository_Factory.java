package ru.nightgoat.volunteer.data.locationRepo;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LocationRepository_Factory implements Factory<LocationRepository> {
  private final Provider<Context> contextProvider;

  public LocationRepository_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public LocationRepository get() {
    return newInstance(contextProvider.get());
  }

  public static LocationRepository_Factory create(Provider<Context> contextProvider) {
    return new LocationRepository_Factory(contextProvider);
  }

  public static LocationRepository newInstance(Context context) {
    return new LocationRepository(context);
  }
}
