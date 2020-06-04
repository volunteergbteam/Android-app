package ru.nightgoat.volunteer.data.locationRepo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Single
import ru.nightgoat.volunteer.utils.countDistance
import java.io.IOException
import java.util.*
import javax.inject.Inject


class LocationRepository @Inject constructor(private val context: Context){

    private val mFusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    private val geocoder = Geocoder(context)
    private lateinit var lastKnownLocation: Location
    
    fun getLastLocation(): Single<LatLng> {
        return Single.create { emitter ->
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                mFusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    if (location != null) {
                        lastKnownLocation = location
                        emitter.onSuccess(LatLng(location.latitude, location.longitude))

                    } else emitter.onError(Throwable("Your location settings is turned off"))
                }
            } else emitter.onError(Throwable("You haven't given the permissions"))
        }
    }

    fun geocodeAndFindClosestLatLntFromString(address: String) : Single<LatLng>{
        return Single.create { emitter ->
            getLastLocation().subscribe({ currentLocation ->
                try {
                    val listOfAddresses = geocoder.getFromLocationName(address, 5)
                    if (listOfAddresses.isNotEmpty()) {
                        val closestAddress = findClosestAddress(currentLocation, listOfAddresses)
                        val closestLatLng = LatLng(closestAddress.latitude, closestAddress.longitude)
                        emitter.onSuccess(closestLatLng)
                    } else {
                        emitter.onError(Throwable("Place not found"))
                    }
                } catch (e: IOException) {
                    emitter.onError(e)
                }
            }, {
                emitter.onError(it)
            })
        }
    }

    fun geocodeAndFindAddressFromLatLng(latlng: LatLng) : Single<String> {
        return Single.create { emitter ->
            try {
                val addresses = geocoder.getFromLocation(latlng.latitude, latlng.longitude, 1)
                emitter.onSuccess(addresses[0].getAddressLine(0))
            } catch (e: IOException){
                emitter.onError(e)
            }
        }
    }

    private fun findClosestAddress(currentLocation: LatLng, list: List<Address>) : Address {
            var closestArea: Address = list[0]
            for (address in list) {
                if (countDistance(currentLocation, LatLng(address.latitude, address.longitude)) <
                    countDistance(currentLocation, LatLng(closestArea.latitude, closestArea.longitude))
                )
                    closestArea = address
            }
            return closestArea
        }
}