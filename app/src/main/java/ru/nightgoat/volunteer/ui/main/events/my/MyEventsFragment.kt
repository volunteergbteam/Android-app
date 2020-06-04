package ru.nightgoat.volunteer.ui.main.events.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.fragment_events_my.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.extentions.popBackStack
import ru.nightgoat.volunteer.ui.base.BaseFragment
import javax.inject.Inject

class MyEventsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MyEventsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MyEventsViewModel::class.java)
    }

    private lateinit var listAdapter : MyEventsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = MyEventsListAdapter(viewModel)
        initRecycler()
        viewModel.subscribeToMyEvents()
        onBackBtnClickListener()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.eventLiveData.observe(viewLifecycleOwner, Observer {
            listAdapter.addEvent(it)
        })
    }

    private fun onBackBtnClickListener() {
        events_my_toolbar.setNavigationOnClickListener {
            popBackStack()
        }
    }

    private fun initRecycler() {
        events_my_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }
}
