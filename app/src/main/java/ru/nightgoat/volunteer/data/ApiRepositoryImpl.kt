package ru.nightgoat.volunteer.data

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.nightgoat.volunteer.data.db.mDao
import ru.nightgoat.volunteer.data.model.Area
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.data.network.API
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User

class ApiRepositoryImpl(private val mDao: mDao, private val api: API) : Repository {
    override fun getEvents(locationId: Int) : Flowable<List<EventModel>> {
        return api.getEventsForCity(locationId)
            .subscribeOn(Schedulers.io())
            .map { it.eventsList }
            .toFlowable()
    }

    override fun addUserToDatabase(user: User): Completable {
        return Completable.error(Throwable("This repository not implemented!"))
    }

    override fun createUser(email: String, password: String): Completable {
        return Completable.error(Throwable("This repository not implemented!"))
    }

    override fun sendConfirmationEmail(): Completable {
        return Completable.error(Throwable("This repository not implemented!"))
    }

    override fun getUser(): Single<User> {
        return Single.error(Throwable("This repository not implemented!"))
    }

    override fun addEvent(
        title: String,
        description: String,
        latLng: LatLng,
        whenEnds: Long,
        city: Int,
        eventsSize: Int,
        status: Int
    ): Completable {
        return Completable.error(Throwable("This repository not implemented!"))

    }

    override fun getAreas(): Single<List<Area>> {
        return Single.error(Throwable("This repository not implemented!"))
    }

}