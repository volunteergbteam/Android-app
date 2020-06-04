package ru.nightgoat.volunteer.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.nightgoat.volunteer.data.db.mDao;
import ru.nightgoat.volunteer.data.network.API;
import ru.nightgoat.volunteer.domain.Repository;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideApiRepositoryFactory implements Factory<Repository> {
  private final Provider<mDao> daoProvider;

  private final Provider<API> apiProvider;

  public DataModule_ProvideApiRepositoryFactory(Provider<mDao> daoProvider,
      Provider<API> apiProvider) {
    this.daoProvider = daoProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public Repository get() {
    return provideApiRepository(daoProvider.get(), apiProvider.get());
  }

  public static DataModule_ProvideApiRepositoryFactory create(Provider<mDao> daoProvider,
      Provider<API> apiProvider) {
    return new DataModule_ProvideApiRepositoryFactory(daoProvider, apiProvider);
  }

  public static Repository provideApiRepository(mDao dao, API api) {
    return Preconditions.checkNotNull(DataModule.INSTANCE.provideApiRepository(dao, api), "Cannot return null from a non-@Nullable @Provides method");
  }
}
