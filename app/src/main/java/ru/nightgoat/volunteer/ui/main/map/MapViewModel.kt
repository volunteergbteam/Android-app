package ru.nightgoat.volunteer.ui.main.map

import androidx.lifecycle.MutableLiveData
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import javax.inject.Inject

class MapViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    val eventsListLiveData = MutableLiveData<List<EventModel>>()
    val toastLiveData = MutableLiveData<String>()

    fun subscribeToEventsByGeo(){
        compositeDisposable.add(
            interactor.getEventsByGeo().subscribe({
                eventsListLiveData.value = it
            }, {
                toastLiveData.value = it.message
            })
        )
    }

    companion object {
        val TAG = MapViewModel::class.simpleName
    }

}