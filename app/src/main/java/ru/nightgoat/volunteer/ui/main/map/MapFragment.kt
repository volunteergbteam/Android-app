package ru.nightgoat.volunteer.ui.main.map

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.frag_map.*
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.extentions.navigateTo
import ru.nightgoat.volunteer.extentions.showShortToast
import ru.nightgoat.volunteer.ui.base.BaseFragment
import ru.nightgoat.volunteer.ui.main.map.addEvent.AddEventFragment
import ru.nightgoat.volunteer.ui.main.map.event.EventFragment
import ru.nightgoat.volunteer.utils.descriptBitMap
import timber.log.Timber
import javax.inject.Inject

class MapFragment : BaseFragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener, ParentFragment {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var eventsList: List<EventModel>
    private lateinit var markerLatLngGetter: MarkerLatLngGetter

    private val viewModel: MapViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MapViewModel::class.java)
    }

    private lateinit var googleMap: GoogleMap
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var currentCoord: LatLng
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    private lateinit var tempMarker : Marker

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onAddEventClickListener()
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED) {
            map_view.onCreate(savedInstanceState)
            map_view.onResume()
            map_view.getMapAsync(this)
            createLocationRequest()
            observeViewModel()
            childFragmentManager.beginTransaction().add(R.id.map_bottom_sheet, EventFragment())
            viewModel.subscribeToEventsByGeo()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), 100
            )
            activity?.recreate()
        }
    }

    private fun observeViewModel() {
        viewModel.eventsListLiveData.observe(viewLifecycleOwner, Observer { listOfEvents ->
            eventsList = listOfEvents
            for (i in listOfEvents.indices) {
                val bitmap = when (eventsList[i].status) {
                    1 -> descriptBitMap(R.drawable.orange_logo)
                    2 -> descriptBitMap(R.drawable.fire)
                    else -> descriptBitMap(R.drawable.green_logo)
                }
                if (this::googleMap.isInitialized){
                    val marker = googleMap.addMarker(
                        MarkerOptions()
                            .position(
                                LatLng(listOfEvents[i].lat, listOfEvents[i].lon)
                            )
                            .title(listOfEvents[i].title)
                            .icon(bitmap)
                    )
                    marker.tag = i
                }
            }
        })
        viewModel.toastLiveData.observe(viewLifecycleOwner, Observer {
            showShortToast(it)
        })
    }

    private fun onAddEventClickListener() {
        map_fab_add.setOnClickListener {
            val fragment = AddEventFragment.newInstance(this)
            markerLatLngGetter = fragment
            childFragmentManager.beginTransaction().replace(R.id.map_bottom_sheet,
                fragment
            ).commit()
            val bottomSheetBehavior = BottomSheetBehavior.from(map_bottom_sheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest.create().apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult?) {
                if (p0 == null) {
                    return
                }
                for (location in p0.locations) {
                    if (location != null) {
                        currentCoord = LatLng(location.latitude, location.longitude)
                    }
                }
            }
        }
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), 100
            )
        }
        LocationServices.getFusedLocationProviderClient(requireActivity())
            .requestLocationUpdates(locationRequest, locationCallback, null)
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let { readyMap ->
            googleMap = readyMap
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(), arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ), 100
                )
            }
            googleMap.isMyLocationEnabled = true
            googleMap.setOnMarkerClickListener(this)
            getLocationAndZoom(10f)
//            map_fab_getPosition.setOnClickListener {
//                getLocationAndZoom(15f)
//            }
            onMarkerDraggedListener()
            onMapClickListener()
        }
    }

    private fun onMapClickListener() {
        googleMap.setOnMapClickListener {
            if (this::tempMarker.isInitialized) tempMarker.remove()
        }
    }

    private fun getLocationAndZoom(zoom: Float) {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), 100
            )
        }
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener {
                it?.let {
                    currentCoord = LatLng(
                        it.latitude,
                        it.longitude
                    )
                    googleMap.moveCamera(
                        CameraUpdateFactory
                            .newLatLngZoom(currentCoord, zoom)
                    )
                }
            }
            .addOnFailureListener {
                showShortToast(it.message.toString())
            }
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        return if (p0 != null && p0.tag != -1) {
            val event = eventsList[p0.tag.toString().toInt()]
            childFragmentManager
                .beginTransaction()
                .replace(R.id.map_bottom_sheet, EventFragment.newInstance(event, this))
                .commit()
            val bottomSheetBehavior = BottomSheetBehavior.from(map_bottom_sheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            googleMap.moveCamera(
                CameraUpdateFactory
                    .newLatLngZoom(LatLng(event.lat, event.lon), 15f)
            )
            true
        } else false
    }

    override fun moveMapTo(destination: LatLng) {
        Timber.d("moveCamera to ${destination.describeContents()}")
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(destination, 15f))
        tempMarker = googleMap.addMarker(
            MarkerOptions()
                .position(
                    LatLng(destination.latitude, destination.longitude)
                )
                .draggable(true)
        )
        tempMarker.tag = -1
    }

    override fun closeBottomPanel() {
        val bottomSheetBehavior = BottomSheetBehavior.from(map_bottom_sheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun goToChat(event: EventModel) {
        val bundle = Bundle()
        bundle.putParcelable("event", event)
        navigateTo(R.id.action_navigation_map_to_navigation_chat, bundle)
    }

    private fun onMarkerDraggedListener() {
        googleMap.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {
            override fun onMarkerDragEnd(p0: Marker?) {
                p0?.position?.let{ markerLatLngGetter.getMarkerLatLng(it) }
            }

            override fun onMarkerDragStart(p0: Marker?) {
            }

            override fun onMarkerDrag(p0: Marker?) {

            }
        })
    }

}
