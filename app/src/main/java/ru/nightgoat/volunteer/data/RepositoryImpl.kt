package ru.nightgoat.volunteer.data

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.nightgoat.volunteer.data.db.mDao
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.data.network.API
import ru.nightgoat.volunteer.data.network.model.EventModel

class RepositoryImpl(private val mDao: mDao, private val api: API): Repository{
    override fun getEvents(locationId: Int) : Single<List<EventModel>> {
        return api.getEventsForCity(locationId)
            .subscribeOn(Schedulers.io())
            .map { it.eventsList }
    }

}