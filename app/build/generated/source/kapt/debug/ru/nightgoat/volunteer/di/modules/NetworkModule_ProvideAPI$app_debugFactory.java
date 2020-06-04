package ru.nightgoat.volunteer.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;
import ru.nightgoat.volunteer.data.network.API;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideAPI$app_debugFactory implements Factory<API> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideAPI$app_debugFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public API get() {
    return provideAPI$app_debug(retrofitProvider.get());
  }

  public static NetworkModule_ProvideAPI$app_debugFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideAPI$app_debugFactory(retrofitProvider);
  }

  public static API provideAPI$app_debug(Retrofit retrofit) {
    return Preconditions.checkNotNull(NetworkModule.provideAPI$app_debug(retrofit), "Cannot return null from a non-@Nullable @Provides method");
  }
}
