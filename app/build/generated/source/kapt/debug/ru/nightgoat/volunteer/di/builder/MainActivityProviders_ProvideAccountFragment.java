package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.account.account_fragment.AccountFragment;

@Module(
  subcomponents = MainActivityProviders_ProvideAccountFragment.AccountFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideAccountFragment {
  private MainActivityProviders_ProvideAccountFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AccountFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AccountFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface AccountFragmentSubcomponent extends AndroidInjector<AccountFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AccountFragment> {}
  }
}
