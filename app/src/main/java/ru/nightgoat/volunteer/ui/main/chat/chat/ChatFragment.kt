package ru.nightgoat.volunteer.ui.main.chat.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_chat.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.objects.ChatMessage
import ru.nightgoat.volunteer.ui.base.BaseFragment
import ru.nightgoat.volunteer.utils.USERS
import timber.log.Timber
import javax.inject.Inject

class ChatFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ChatViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ChatViewModel::class.java)
    }

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val eventId : String by lazy {
        requireArguments().getString("eventId")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
        initRecycler()
        observeViewModel()
        viewModel.listenToMessages(eventId)
        onSendBtnClickListener()
    }


    private fun onSendBtnClickListener() {
        chat_btn_send.setOnClickListener {
            chat_edit_input.text.apply {
                if (isNotEmpty()) {
                    viewModel.sendMessage(eventId, this.toString())
                    clear()
                }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.messagesLiveData.observe(viewLifecycleOwner, Observer { message ->
            if (message.fromId == Firebase.auth.currentUser?.uid) groupAdapter.add(ChatSentItem(message))
            else groupAdapter.add(ChatReceivedItem(message))
        })
    }

    private fun initRecycler() {
        chat_recycler.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.stackFromEnd = true
            layoutManager = linearLayoutManager
            adapter = groupAdapter
        }
    }

}
