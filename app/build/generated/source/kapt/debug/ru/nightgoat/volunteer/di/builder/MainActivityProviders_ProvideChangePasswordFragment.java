package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.account.changePass.ChangePasswordFragment;

@Module(
  subcomponents =
      MainActivityProviders_ProvideChangePasswordFragment.ChangePasswordFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideChangePasswordFragment {
  private MainActivityProviders_ProvideChangePasswordFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ChangePasswordFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChangePasswordFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ChangePasswordFragmentSubcomponent
      extends AndroidInjector<ChangePasswordFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChangePasswordFragment> {}
  }
}
