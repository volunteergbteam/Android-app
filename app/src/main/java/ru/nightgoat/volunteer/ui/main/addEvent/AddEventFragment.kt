package ru.nightgoat.volunteer.ui.main.addEvent

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.frag_map_add_event.*

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.extentions.popBackStack
import ru.nightgoat.volunteer.ui.base.BaseFragment
import javax.inject.Inject

class AddEventFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: AddEventViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AddEventViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_map_add_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCancelBtnClickListener()
        onSaveBtnClickListener()
    }

    private fun onSaveBtnClickListener() {
        addEvent_btn_save.setOnClickListener {
            saveEvent()
            popBackStack()
        }
    }

    private fun saveEvent() {
        val geocoder = Geocoder(context)

    }

    private fun onCancelBtnClickListener() {
        addEvent_toolbar.setNavigationOnClickListener {
            popBackStack()
        }
    }



}
