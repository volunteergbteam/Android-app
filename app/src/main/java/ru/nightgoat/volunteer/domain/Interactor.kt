package ru.nightgoat.volunteer.domain

import io.reactivex.Single
import ru.nightgoat.volunteer.data.network.model.EventModel
import ru.nightgoat.volunteer.ui.main.map.MapViewModel
import timber.log.Timber

class Interactor(private val repository: Repository) {
    fun getEvents(locationId: Int) : Single<List<EventModel>> {
        Timber.tag(TAG).d("getEvents()")
        return repository.getEvents(locationId)
    }

    companion object {
        val TAG = Interactor::class.simpleName
    }
}


