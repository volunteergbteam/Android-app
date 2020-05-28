package ru.nightgoat.volunteer.ui.main.map

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import timber.log.Timber
import java.io.BufferedReader
import javax.inject.Inject

class MapViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel() {

    val eventsListLiveData = MutableLiveData<List<EventModel>>()
    val toastLiveData = MutableLiveData<String>()

    fun subscribeToEvents(){
        compositeDisposable.add(
            interactor.getEvents().subscribe({
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