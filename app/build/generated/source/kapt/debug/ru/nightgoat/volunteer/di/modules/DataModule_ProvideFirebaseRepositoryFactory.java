package ru.nightgoat.volunteer.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.domain.Repository;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideFirebaseRepositoryFactory implements Factory<Repository> {
  @Override
  public Repository get() {
    return provideFirebaseRepository();
  }

  public static DataModule_ProvideFirebaseRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Repository provideFirebaseRepository() {
    return Preconditions.checkNotNull(DataModule.INSTANCE.provideFirebaseRepository(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final DataModule_ProvideFirebaseRepositoryFactory INSTANCE = new DataModule_ProvideFirebaseRepositoryFactory();
  }
}
