package ru.nightgoat.volunteer.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.nightgoat.volunteer.data.db.VolunteerDatabase;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideDataBaseFactory implements Factory<VolunteerDatabase> {
  private final Provider<Context> contextProvider;

  public DataModule_ProvideDataBaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public VolunteerDatabase get() {
    return provideDataBase(contextProvider.get());
  }

  public static DataModule_ProvideDataBaseFactory create(Provider<Context> contextProvider) {
    return new DataModule_ProvideDataBaseFactory(contextProvider);
  }

  public static VolunteerDatabase provideDataBase(Context context) {
    return Preconditions.checkNotNull(DataModule.INSTANCE.provideDataBase(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
