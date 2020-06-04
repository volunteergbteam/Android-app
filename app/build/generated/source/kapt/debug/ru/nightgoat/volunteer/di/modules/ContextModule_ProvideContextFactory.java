package ru.nightgoat.volunteer.di.modules;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ContextModule_ProvideContextFactory implements Factory<Context> {
  private final ContextModule module;

  private final Provider<Application> applicationProvider;

  public ContextModule_ProvideContextFactory(ContextModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Context get() {
    return provideContext(module, applicationProvider.get());
  }

  public static ContextModule_ProvideContextFactory create(ContextModule module,
      Provider<Application> applicationProvider) {
    return new ContextModule_ProvideContextFactory(module, applicationProvider);
  }

  public static Context provideContext(ContextModule instance, Application application) {
    return Preconditions.checkNotNull(instance.provideContext(application), "Cannot return null from a non-@Nullable @Provides method");
  }
}
