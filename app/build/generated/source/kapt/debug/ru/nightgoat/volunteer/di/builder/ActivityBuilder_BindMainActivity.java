package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.MainActivity;

@Module(subcomponents = ActivityBuilder_BindMainActivity.MainActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class ActivityBuilder_BindMainActivity {
  private ActivityBuilder_BindMainActivity() {}

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent(modules = MainActivityProviders.class)
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
  }
}
