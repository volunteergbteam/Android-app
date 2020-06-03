package ru.nightgoat.volunteer.ui.main.map

import com.google.android.gms.maps.model.LatLng

interface MapMover {
    fun moveMapTo(destination: LatLng)
    fun closeBottomPanel()
}
