package ru.nightgoat.volunteer.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.nightgoat.volunteer.data.db.VolunteerDatabase;
import ru.nightgoat.volunteer.data.db.mDao;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideDaoFactory implements Factory<mDao> {
  private final Provider<VolunteerDatabase> citiesDatabaseProvider;

  public DataModule_ProvideDaoFactory(Provider<VolunteerDatabase> citiesDatabaseProvider) {
    this.citiesDatabaseProvider = citiesDatabaseProvider;
  }

  @Override
  public mDao get() {
    return provideDao(citiesDatabaseProvider.get());
  }

  public static DataModule_ProvideDaoFactory create(
      Provider<VolunteerDatabase> citiesDatabaseProvider) {
    return new DataModule_ProvideDaoFactory(citiesDatabaseProvider);
  }

  public static mDao provideDao(VolunteerDatabase citiesDatabase) {
    return Preconditions.checkNotNull(DataModule.INSTANCE.provideDao(citiesDatabase), "Cannot return null from a non-@Nullable @Provides method");
  }
}
