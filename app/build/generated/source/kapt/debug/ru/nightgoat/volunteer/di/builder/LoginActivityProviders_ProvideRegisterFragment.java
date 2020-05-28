package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.login.register.RegisterFragment;

@Module(
  subcomponents = LoginActivityProviders_ProvideRegisterFragment.RegisterFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class LoginActivityProviders_ProvideRegisterFragment {
  private LoginActivityProviders_ProvideRegisterFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RegisterFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RegisterFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface RegisterFragmentSubcomponent extends AndroidInjector<RegisterFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<RegisterFragment> {}
  }
}
