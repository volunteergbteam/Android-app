package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.login.LoginActivity;

@Module(subcomponents = ActivityBuilder_BindLoginActivity.LoginActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class ActivityBuilder_BindLoginActivity {
  private ActivityBuilder_BindLoginActivity() {}

  @Binds
  @IntoMap
  @ClassKey(LoginActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      LoginActivitySubcomponent.Factory builder);

  @Subcomponent(modules = LoginActivityProviders.class)
  public interface LoginActivitySubcomponent extends AndroidInjector<LoginActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<LoginActivity> {}
  }
}
