package ru.nightgoat.volunteer.ui.main.map.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.ui.base.BaseFragment
import ru.nightgoat.volunteer.ui.main.map.addEvent.AddEventViewModel
import javax.inject.Inject

import kotlinx.android.synthetic.main.frag_map_event.*

class EventFragment : BaseFragment(){
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var eventId: String

    private val viewModel: EventViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(EventViewModel::class.java)
    }

    companion object {
        fun newInstance(event: EventModel) = EventFragment().apply {
            arguments = bundleOf(
                "title" to event.title,
                "description" to event.description,
                "eventId" to event.id
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_map_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            frag_map_event_title.text = it.getString("title")
            frag_map_event_description.text = it.getString("description")
            eventId = it.getString("eventId").toString()
        }
        onHelpBtnClickListener()
    }

    /* 1. Добавляет юзеру в helpsEvents / city / eventId
     * 2. event.status = 1
     * 3. Создает chats / city / eventId / ChatRoom
     * 4. Создает messages / eventId / ChatMessage.message = Здравствуйте! Я хочу вам помочь!
     */
    private fun onHelpBtnClickListener() {
        frag_map_event_subscribe.setOnClickListener {
            viewModel.onHelpBtnClick(eventId)
        }
    }
}