package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.login.password_recovery.PasswordRecoverFragment;

@Module(
  subcomponents =
      LoginActivityProviders_ProvidePasswordRecoverFragment.PasswordRecoverFragmentSubcomponent
          .class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class LoginActivityProviders_ProvidePasswordRecoverFragment {
  private LoginActivityProviders_ProvidePasswordRecoverFragment() {}

  @Binds
  @IntoMap
  @ClassKey(PasswordRecoverFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PasswordRecoverFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface PasswordRecoverFragmentSubcomponent
      extends AndroidInjector<PasswordRecoverFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<PasswordRecoverFragment> {}
  }
}
