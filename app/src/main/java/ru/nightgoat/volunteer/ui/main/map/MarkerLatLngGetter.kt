package ru.nightgoat.volunteer.ui.main.map

import com.google.android.gms.maps.model.LatLng

interface MarkerLatLngGetter {
    fun getMarkerLatLng(markerLatLng: LatLng)
}
