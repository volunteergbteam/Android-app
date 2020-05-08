package ru.nightgoat.volunteer.ui.main.map

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.android.synthetic.main.fragment_map.*
import ru.nightgoat.volunteer.R
import ru.nightgoat.volunteer.data.network.model.EventModel
import ru.nightgoat.volunteer.ui.base.BaseFragment
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class MapFragment : BaseFragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var eventsList : List<EventModel>

    private val viewModel: MapViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(MapViewModel::class.java)
    }

    private lateinit var googleMap: GoogleMap
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var currentCoord: LatLng

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onAddEventClickListener()
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        if (isPermissionGranted()) {
            createLocationRequest()
            map_view.onCreate(savedInstanceState)
            map_view.onResume()
            map_view.getMapAsync(this)
            observeViewModel()
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
        lifecycle.addObserver(viewModel)
        viewModel.eventsListLiveData.observe(viewLifecycleOwner, Observer { listOfEvents ->
            eventsList = listOfEvents
            for (i in listOfEvents.indices) {
                Timber.tag(TAG).d(listOfEvents[i].id.toString())
                val marker = googleMap.addMarker(
                    MarkerOptions()
                        .position(
                            LatLng(listOfEvents[i].locationLat, listOfEvents[i].locationLon)
                        )
                        .title(listOfEvents[i].title)
                )
                marker.tag = i
            }
        })
        viewModel.toastLiveData.observe(viewLifecycleOwner, Observer {
            showShortToast(it)
        })
    }

    private fun onAddEventClickListener() {
        map_fab_add.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_map_to_navigation_addEvent)
        }
    }

    private fun createLocationRequest() {
        val locationRequest = LocationRequest.create()?.apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult?) {
                if (p0 == null) {
                    return
                }
            }
        }
        LocationServices.getFusedLocationProviderClient(requireActivity())
            .requestLocationUpdates(locationRequest, locationCallback, null)
    }

    private fun isPermissionGranted(): Boolean {
        return (ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED)
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let { readyMap ->
            googleMap = readyMap
            googleMap.isMyLocationEnabled = true
            googleMap.setOnMarkerClickListener(this)
            getLocationAndZoom(10f)
            map_fab_getPosition.setOnClickListener {
                getLocationAndZoom(15f)
            }
        }
    }

    private fun getLocationAndZoom(zoom: Float) {
        fusedLocationProviderClient.lastLocation
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    currentCoord = LatLng(
                        it.result!!.latitude,
                        it.result!!.longitude
                    )
                    googleMap.moveCamera(
                        CameraUpdateFactory
                            .newLatLngZoom(currentCoord, zoom)
                    )
                } else {
                    Toast.makeText(
                        requireContext(),
                        "unable to get current location",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        map_view.onSaveInstanceState(outState)
    }

    companion object {
        val TAG = MapFragment::class.simpleName
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        return if (p0 != null) {
            val event = eventsList[p0.tag.toString().toInt()]
            map_bottom_sheet_title.text = event.title
            map_bottom_sheet_description.text = event.description
            val bottomSheetBehavior = BottomSheetBehavior.from(map_bottom_sheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            googleMap.moveCamera(CameraUpdateFactory
                .newLatLngZoom(LatLng(event.locationLat, event.locationLon), 15f))
            true
        }
       else false
    }

}
