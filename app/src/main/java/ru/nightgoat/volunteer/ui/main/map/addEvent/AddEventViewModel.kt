package ru.nightgoat.volunteer.ui.main.map.addEvent


import android.location.Address
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.model.LatLng
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import javax.inject.Inject

class AddEventViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    private val geocodedLatLngMutableLiveData = MutableLiveData<LatLng>()
    val geocodedLatLngLiveData : LiveData<LatLng> = geocodedLatLngMutableLiveData

    private val isAddressOkMutableLiveData = MutableLiveData<Boolean>()
    val isAddressOkLiveData : LiveData<Boolean> = isAddressOkMutableLiveData

    private val draggedMarkerAddressMutableLiveData = MutableLiveData<String>()
    val draggedMarkerAddressLiveData : LiveData<String> = draggedMarkerAddressMutableLiveData

    fun addEvent(title: String, description: String, latLng: LatLng, whenEnds: Long, status: Int){
        compositeDisposable.add(
            interactor.addEvent(title, description, latLng, whenEnds, status).subscribe()
        )
    }

    fun findClosestAddress(address: String){
        compositeDisposable.add(
            interactor.searchLocation(address)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    geocodedLatLngMutableLiveData.value = it
                    isAddressOkMutableLiveData.value = true
                }, {
                    geocodedLatLngMutableLiveData.value = null
                    isAddressOkMutableLiveData.value = false
        }))
    }

    fun geoCodeLatLng(latlng: LatLng) {
        compositeDisposable.add(
            interactor.geocodeAndFindAddressFromLatLng(latlng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                draggedMarkerAddressMutableLiveData.value = it
            }, {
                draggedMarkerAddressMutableLiveData.value = ""
            })
        )
    }
}
