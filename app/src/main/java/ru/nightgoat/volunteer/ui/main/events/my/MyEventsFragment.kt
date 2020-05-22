package ru.nightgoat.volunteer.ui.main.events.my

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_events_my.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.ui.main.events.active.ActiveEventsListAdapter
import javax.inject.Inject

class MyEventsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MyEventsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MyEventsViewModel::class.java)
    }

    private val listAdapter = ActiveEventsListAdapter(viewModel)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackBtnClickListener()
        initRecycler()
    }

    private fun onBackBtnClickListener() {
        events_my_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initRecycler() {
        events_my_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }
}
