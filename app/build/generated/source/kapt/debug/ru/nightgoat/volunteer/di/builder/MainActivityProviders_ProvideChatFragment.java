package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.chat.chat.ChatFragment;

@Module(subcomponents = MainActivityProviders_ProvideChatFragment.ChatFragmentSubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideChatFragment {
  private MainActivityProviders_ProvideChatFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ChatFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChatFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ChatFragmentSubcomponent extends AndroidInjector<ChatFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChatFragment> {}
  }
}
