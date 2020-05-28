package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.settings.SettingsFragment;

@Module(
  subcomponents = MainActivityProviders_ProvideSettingsFragment.SettingsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideSettingsFragment {
  private MainActivityProviders_ProvideSettingsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SettingsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SettingsFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface SettingsFragmentSubcomponent extends AndroidInjector<SettingsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SettingsFragment> {}
  }
}
