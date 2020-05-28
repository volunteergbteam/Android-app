package ru.nightgoat.volunteer.domain

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User

interface Repository {

    fun getEvents(locationId: Int) : Flowable<List<EventModel>>

    fun addUserToDatabase(user: User) : Completable

    fun createUser(email: String, password: String) : Completable

    fun sendConfirmationEmail() : Completable

    fun getUser() : Single<User>
}