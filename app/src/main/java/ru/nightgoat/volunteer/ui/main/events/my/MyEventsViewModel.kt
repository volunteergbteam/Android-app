package ru.nightgoat.volunteer.ui.main.events.my

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.domain.Interactor
import ru.nightgoat.volunteer.ui.base.BaseViewModel
import ru.nightgoat.volunteer.ui.main.events.EventsClickListener
import timber.log.Timber
import javax.inject.Inject

class MyEventsViewModel @Inject constructor(private val interactor: Interactor) : BaseViewModel(),
    EventsClickListener {

    private val eventMutableLiveData = MutableLiveData<EventModel>()
    val eventLiveData : LiveData<EventModel> = eventMutableLiveData


    fun subscribeToMyEvents(){
        compositeDisposable.add(
            interactor.getMyEvents().subscribe({
                eventMutableLiveData.value = it
                Timber.d(it.title)
            }, {
                Timber.e(it)
            }))
    }

    override fun onCheckCompletedBtnClickListener(eventId: String) {

    }

    override fun onCancelBtnClickListener(eventId: String) {

    }
}