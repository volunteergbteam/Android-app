package ru.nightgoat.volunteer.ui.main.events.my

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.nightgoat.volunteer.R

class MyEventsFragment : Fragment() {

    companion object {
        fun newInstance() = MyEventsFragment()
    }

    private lateinit var viewModel: MyEventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events_my, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyEventsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
