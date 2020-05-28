package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.events.my.MyEventsFragment;

@Module(
  subcomponents = MainActivityProviders_ProvideMyEventsFragment.MyEventsFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideMyEventsFragment {
  private MainActivityProviders_ProvideMyEventsFragment() {}

  @Binds
  @IntoMap
  @ClassKey(MyEventsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MyEventsFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface MyEventsFragmentSubcomponent extends AndroidInjector<MyEventsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MyEventsFragment> {}
  }
}
