package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.map.event.EventFragment;

@Module(subcomponents = MainActivityProviders_ProvideEventFragment.EventFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideEventFragment {
  private MainActivityProviders_ProvideEventFragment() {}

  @Binds
  @IntoMap
  @ClassKey(EventFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      EventFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface EventFragmentSubcomponent extends AndroidInjector<EventFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<EventFragment> {}
  }
}
