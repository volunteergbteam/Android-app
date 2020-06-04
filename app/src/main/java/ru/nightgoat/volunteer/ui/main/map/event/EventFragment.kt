package ru.nightgoat.volunteer.ui.main.map.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.ui.base.BaseFragment
import ru.nightgoat.volunteer.ui.main.map.addEvent.AddEventViewModel
import javax.inject.Inject

import kotlinx.android.synthetic.main.frag_map_event.*
import ru.nightgoat.volunteer.extentions.navigateTo
import ru.nightgoat.volunteer.extentions.showShortToast
import ru.nightgoat.volunteer.ui.main.map.ParentFragment

class EventFragment : BaseFragment(){
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var event: EventModel
    private lateinit var parent: ParentFragment

    private val viewModel: EventViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(EventViewModel::class.java)
    }

    companion object {
        fun newInstance(event: EventModel, parent: ParentFragment) = EventFragment().apply {
            this.parent = parent
            this.event = event
            arguments = bundleOf(
                "event" to event
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
        event = arguments?.getParcelable("event")!!
        setTextFields()
        onHelpBtnClickListener()
    }

    private fun setTextFields() {
        frag_map_event_title.text = event.title
        frag_map_event_description.text = event.description
        frag_map_event_address.text = event.address
    }

    /* 1. Добавляет юзеру в helpsEvents / city / eventId
     * 2. event.status = 1
     * 3. Создает chats / city / eventId / ChatRoom
     * 4. Создает messages / eventId / ChatMessage.message = Здравствуйте! Я хочу вам помочь!
     */
    private fun onHelpBtnClickListener() {
        frag_map_event_subscribe.setOnClickListener {
            viewModel.onHelpBtnClick(event, parent)
        }
    }
}