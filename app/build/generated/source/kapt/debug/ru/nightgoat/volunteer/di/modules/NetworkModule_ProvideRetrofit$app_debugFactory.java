package ru.nightgoat.volunteer.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideRetrofit$app_debugFactory implements Factory<Retrofit> {
  @Override
  public Retrofit get() {
    return provideRetrofit$app_debug();
  }

  public static NetworkModule_ProvideRetrofit$app_debugFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Retrofit provideRetrofit$app_debug() {
    return Preconditions.checkNotNull(NetworkModule.provideRetrofit$app_debug(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideRetrofit$app_debugFactory INSTANCE = new NetworkModule_ProvideRetrofit$app_debugFactory();
  }
}
