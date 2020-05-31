package ru.nightgoat.volunteer.ui.main.map.addEvent

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.location.Geocoder
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.database.ktx.database
import kotlinx.android.synthetic.main.frag_map_add_event.*
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.extentions.popBackStack
import ru.nightgoat.volunteer.extentions.showShortToast
import ru.nightgoat.volunteer.ui.base.BaseFragment
import ru.nightgoat.volunteer.ui.main.map.MapMover
import ru.nightgoat.volunteer.ui.main.map.MarkerLatLngGetter
import timber.log.Timber
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject


class AddEventFragment : BaseFragment(), MarkerLatLngGetter {

    companion object {
        fun newInstance(mapFragment: MapMover) = AddEventFragment().apply {
            mapMover = mapFragment
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var latlng: LatLng
    private var isHeaderNotEmpty = false
    private var isDescriptionNotEmpty = false
    private var description = ""
    private var doEventUntil: String = ""
    private lateinit var mapMover: MapMover

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
        onSaveBtnClickListener()
        addressTextListener()
        timerClickListener()
        checkFields()
        observeViewModel()
    }

    @SuppressLint("SetTextI18n")
    private fun timerClickListener() {
        addEvent_layout_description.setEndIconOnClickListener {
            val currentMillis = System.currentTimeMillis()
            val currentDay = DateTime(currentMillis).dayOfMonth
            val currentMonth = DateTime(currentMillis).monthOfYear
            val currentYear = DateTime(currentMillis).year
            val datePickerDialog =
                DatePickerDialog(requireContext(), { view, year, month, dayOfMonth ->
                    doEventUntil = String.format(
                        Locale.getDefault(),
                        "%02d.%02d.%d", dayOfMonth, month + 1, year
                    )
                    addEvent_edit_description.setText("До $doEventUntil: $description")
                }, currentYear, currentMonth, currentDay)
            datePickerDialog.show()
        }
    }

    private fun onSaveBtnClickListener() {
         addEvent_btn_save.setOnClickListener {
            Timber.d("SAVE BTN CLICKED")
             if (checkIsBtnClickable()) saveEvent()
        }
    }

    private fun saveEvent() {
        val title = addEvent_edit_header.text.toString()
        val description = addEvent_edit_description.text.toString()
        val checkedId = addEvent_radio_group.indexOfChild(
            addEvent_radio_group.findViewById(
                addEvent_radio_group.checkedRadioButtonId
            )
        )
        viewModel.addEvent(title, description, latlng, dateToLong(doEventUntil), checkedId)
    }

    private fun dateToLong(date: String): Long {
        return if (date.isNotEmpty()) DateTimeFormat.forPattern("dd.MM.yyyy").parseMillis(date)
        else 0
    }

    private fun addressTextListener() {
        addEvent_layout_address.isErrorEnabled = true
        addEvent_edit_address.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.findClosestAddress(addEvent_edit_address.text.toString())
            }
            false
        }
        addEvent_layout_address.setEndIconOnClickListener {
            viewModel.findClosestAddress(addEvent_edit_address.text.toString())
        }
    }

    private fun observeViewModel() {
        viewModel.geocodedLatLngLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            latlng = it
            mapMover.moveMapTo(latlng)
        })
        viewModel.isAddressOkLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer { isAddressOk ->
                if (isAddressOk) {
                    addEvent_layout_address.isErrorEnabled = false
                    addEvent_btn_save.isClickable = checkIsBtnClickable()
                }
                else addEvent_layout_address.error = "Адрес не найден"
            })
        viewModel.draggedMarkerAddressLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                addEvent_edit_address.setText(it)
            })
    }

    private fun checkFields() {
        addEvent_edit_header.addTextChangedListener {
            isHeaderNotEmpty = it.toString().isNotEmpty()
            addEvent_btn_save.isClickable =
                isHeaderNotEmpty && isDescriptionNotEmpty && !addEvent_layout_address.isErrorEnabled
        }
        addEvent_edit_description.addTextChangedListener {
            isDescriptionNotEmpty = it.toString().isNotEmpty()
            description = it.toString()
            addEvent_btn_save.isClickable =
                isHeaderNotEmpty && isDescriptionNotEmpty && !addEvent_layout_address.isErrorEnabled
        }
    }

    override fun getMarkerLatLng(markerLatLng: LatLng) {
        viewModel.geoCodeLatLng(markerLatLng)
    }

    fun checkIsBtnClickable() = isHeaderNotEmpty && isDescriptionNotEmpty && !addEvent_layout_address.isErrorEnabled
}
