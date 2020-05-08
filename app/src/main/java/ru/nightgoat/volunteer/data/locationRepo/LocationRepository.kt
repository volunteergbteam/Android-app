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
import io.reactivex.Single
import java.io.IOException
import java.util.*
import javax.inject.Inject


class LocationRepository @Inject constructor(private val context: Context){

    val mFusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    private lateinit var lastKnownLocation: Location
    
    fun getLastLocation(): Single<String?>? {
        return Single.create { e ->
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                mFusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    if (location != null) {
                        lastKnownLocation = location
                        val geoCoder = Geocoder(context, Locale.getDefault())
                        try {
                            val address: List<Address> =
                                geoCoder.getFromLocation(
                                    location.latitude,
                                    location.longitude,
                                    1
                                )
                            val cityName: String = address[0].locality
                            e.onSuccess(cityName)
                        } catch (e1: IOException) {
                            e.onError(e1)
                        }
                    } else e.onError(Throwable("Your location settings is turned off"))
                }
            } else e.onError(Throwable("You haven't given the permissions"))
        }
    }
}