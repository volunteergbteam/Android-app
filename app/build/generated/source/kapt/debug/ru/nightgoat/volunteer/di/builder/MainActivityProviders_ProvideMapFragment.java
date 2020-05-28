package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.map.MapFragment;

@Module(subcomponents = MainActivityProviders_ProvideMapFragment.MapFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideMapFragment {
  private MainActivityProviders_ProvideMapFragment() {}

  @Binds
  @IntoMap
  @ClassKey(MapFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MapFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface MapFragmentSubcomponent extends AndroidInjector<MapFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MapFragment> {}
  }
}
