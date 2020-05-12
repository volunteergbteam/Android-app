package ru.nightgoat.volunteer.ui.main.events.my

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import ru.nightgoat.volunteer.R
import javax.inject.Inject

class MyEventsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MyEventsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MyEventsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events_my, container, false)
    }

}
