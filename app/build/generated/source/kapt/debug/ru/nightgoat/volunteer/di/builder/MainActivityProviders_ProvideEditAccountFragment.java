package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.account.edit_account.EditAccountFragment;

@Module(
  subcomponents =
      MainActivityProviders_ProvideEditAccountFragment.EditAccountFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideEditAccountFragment {
  private MainActivityProviders_ProvideEditAccountFragment() {}

  @Binds
  @IntoMap
  @ClassKey(EditAccountFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      EditAccountFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface EditAccountFragmentSubcomponent extends AndroidInjector<EditAccountFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<EditAccountFragment> {}
  }
}
