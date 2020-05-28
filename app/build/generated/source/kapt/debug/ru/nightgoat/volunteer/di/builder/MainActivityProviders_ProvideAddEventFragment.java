package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.addEvent.AddEventFragment;

@Module(
  subcomponents = MainActivityProviders_ProvideAddEventFragment.AddEventFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideAddEventFragment {
  private MainActivityProviders_ProvideAddEventFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AddEventFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddEventFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface AddEventFragmentSubcomponent extends AndroidInjector<AddEventFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AddEventFragment> {}
  }
}
