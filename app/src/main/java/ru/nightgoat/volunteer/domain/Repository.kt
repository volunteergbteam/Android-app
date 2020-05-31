package ru.nightgoat.volunteer.domain

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import ru.nightgoat.volunteer.data.model.Area
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User

interface Repository {

    fun getEvents(locationId: Int) : Flowable<List<EventModel>>

    fun addUserToDatabase(user: User) : Completable

    fun createUser(email: String, password: String) : Completable

    fun sendConfirmationEmail() : Completable

    fun getUser() : Single<User>

    fun addEvent(
        title: String,
        description: String,
        latLng: LatLng,
        whenEnds: Long,
        city: Int,
        eventsSize: Int,
        status: Int
    ) : Completable

    fun getAreas() : Single<List<Area>>
}