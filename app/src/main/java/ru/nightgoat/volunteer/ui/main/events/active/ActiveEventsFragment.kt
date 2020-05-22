package ru.nightgoat.volunteer.ui.main.events.active

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.fragment_events_active.*
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.base.BaseFragment
import javax.inject.Inject

class ActiveEventsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModelActive: ActiveEventsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ActiveEventsViewModel::class.java)
    }

    private val listAdapter = ActiveEventsListAdapter(viewModelActive)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events_active, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackBtnClickListener()
        initRecycler()
    }

    private fun onBackBtnClickListener() {
        events_active_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initRecycler() {
        events_active_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

}
