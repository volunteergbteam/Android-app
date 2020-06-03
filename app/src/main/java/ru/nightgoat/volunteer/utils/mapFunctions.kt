package ru.nightgoat.volunteer.utils

import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

fun countDistance(latlng1: LatLng, latlng2: LatLng): Double {
    val theta = latlng1.longitude - latlng2.longitude
    var dist =
        sin(deg2rad(latlng1.latitude)) * sin(deg2rad(latlng2.latitude)) + cos(deg2rad(latlng1.latitude)) * cos(
            deg2rad(latlng2.latitude)
        ) * cos(deg2rad(theta))
    dist = acos(dist)
    dist = rad2deg(dist)
    dist *= 60 * 1.1515
    return dist
}

private fun deg2rad(deg: Double) = deg * Math.PI / 180.0


private fun rad2deg(rad: Double) = (rad * 180.0 / Math.PI)

fun descriptBitMap(resource: Int): BitmapDescriptor = BitmapDescriptorFactory.fromResource(resource)