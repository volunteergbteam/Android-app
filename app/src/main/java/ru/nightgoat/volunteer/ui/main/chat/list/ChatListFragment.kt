package ru.nightgoat.volunteer.ui.main.chat.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.groupiex.plusAssign
import kotlinx.android.synthetic.main.fragment_chat_list.*
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.extentions.navigateTo
import ru.nightgoat.volunteer.objects.ChatRoom
import ru.nightgoat.volunteer.ui.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject

class ChatListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ChatListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ChatListViewModel::class.java)
    }

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag("ChatListFragment").d("onViewCreated")
        viewModel.getChatList()
        initRecycler()
        observeViewModel()
        onChatItemClickListener()
    }

    private fun observeViewModel() {
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            groupAdapter.addAll(it.toChatRoomItem())
        })
    }

    private fun initRecycler() {
        chat_list_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }
    }

    private fun List<ChatRoom>.toChatRoomItem() : List<ChatRoomItem> {
        return this.map { chatRoom ->
            ChatRoomItem(chatRoom)
        }
    }

    private fun onChatItemClickListener() {
        groupAdapter.setOnItemClickListener { item, view ->
            (item as? ChatRoomItem)?.let {
                val bundle = Bundle()
                bundle.putString("eventId", it.getChatRoomEventId())
                navigateTo(R.id.action_navigation_chat_list_to_navigation_chat, bundle)
            }
        }
    }
}
