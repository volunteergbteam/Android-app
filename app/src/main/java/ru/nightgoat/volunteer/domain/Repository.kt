package ru.nightgoat.volunteer.domain

import io.reactivex.Single
import ru.nightgoat.volunteer.data.network.model.EventModel

interface Repository {

    fun getEvents(locationId: Int) : Single<List<EventModel>>
}