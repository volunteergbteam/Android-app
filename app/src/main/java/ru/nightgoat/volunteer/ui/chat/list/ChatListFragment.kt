package ru.nightgoat.volunteer.ui.chat.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.nightgoat.volunteer.R

class ChatListFragment : Fragment() {

    private lateinit var chatListViewModel: ChatListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        chatListViewModel =
                ViewModelProviders.of(this).get(ChatListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_chat_list, container, false)
        chatListViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }
}
