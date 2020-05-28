package ru.nightgoat.volunteer.di.builder;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;
import ru.nightgoat.volunteer.ui.main.chat.list.ChatListFragment;

@Module(
  subcomponents = MainActivityProviders_ProvideChatListFragment.ChatListFragmentSubcomponent.class
)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class MainActivityProviders_ProvideChatListFragment {
  private MainActivityProviders_ProvideChatListFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ChatListFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChatListFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ChatListFragmentSubcomponent extends AndroidInjector<ChatListFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChatListFragment> {}
  }
}
