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

    private val viewModel: AddEventViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AddEventViewModel::class.java)
    }

    companion object {
        fun newInstance(event: EventModel) = EventFragment().apply {
            arguments = bundleOf(
                "title" to event.title,
                "description" to event.description
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
        }
    }
}