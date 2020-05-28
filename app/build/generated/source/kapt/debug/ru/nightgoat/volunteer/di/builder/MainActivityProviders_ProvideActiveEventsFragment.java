package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.events.active.ActiveEventsFragment;

@Module(
  subcomponents =
      MainActivityProviders_ProvideActiveEventsFragment.ActiveEventsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideActiveEventsFragment {
  private MainActivityProviders_ProvideActiveEventsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ActiveEventsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ActiveEventsFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ActiveEventsFragmentSubcomponent extends AndroidInjector<ActiveEventsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ActiveEventsFragment> {}
  }
}
