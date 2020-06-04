package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.account.changeEmail.ChangeEmailFragment;

@Module(
  subcomponents =
      MainActivityProviders_ProvideChangeEmailFragment.ChangeEmailFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideChangeEmailFragment {
  private MainActivityProviders_ProvideChangeEmailFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ChangeEmailFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChangeEmailFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ChangeEmailFragmentSubcomponent extends AndroidInjector<ChangeEmailFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChangeEmailFragment> {}
  }
}
