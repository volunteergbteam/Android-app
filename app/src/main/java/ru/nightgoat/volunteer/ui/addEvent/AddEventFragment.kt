package ru.nightgoat.volunteer.ui.addEvent

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_event.*

import ru.nightgoat.volunteer.R

class AddEventFragment : Fragment() {

    companion object {
        fun newInstance() = AddEventFragment()
    }

    private lateinit var viewModel: AddEventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_event, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddEventViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCancelBtnClickListener()
        onSaveBtnClickListener()
    }

    private fun onSaveBtnClickListener() {
        addEvent_btn_save.setOnClickListener {
            saveEvent()
            findNavController().popBackStack()
        }
    }

    private fun saveEvent() {
    }

    private fun onCancelBtnClickListener() {
        addEvent_toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }



}
