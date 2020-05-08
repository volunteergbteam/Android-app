package ru.nightgoat.volunteer.ui.main.map

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.nightgoat.volunteer.data.network.model.EventModel
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class MapViewModel @Inject constructor(interactor: Interactor) : BaseViewModel() {

    val eventsListLiveData = MutableLiveData<List<EventModel>>()
    val toastLiveData = MutableLiveData<String>()

    init {
        compositeDisposable.add(
            interactor.getEvents(1).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.tag(TAG).d(it.toString())
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