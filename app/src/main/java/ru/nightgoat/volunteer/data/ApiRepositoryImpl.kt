package ru.nightgoat.volunteer.data

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.nightgoat.volunteer.data.db.mDao
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.data.network.API
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User

class ApiRepositoryImpl(private val mDao: mDao, private val api: API): Repository {
    override fun getEvents(locationId: Int) : Flowable<List<EventModel>> {
        return api.getEventsForCity(locationId)
            .subscribeOn(Schedulers.io())
            .map { it.eventsList }
            .toFlowable()
    }

    override fun addUserToDatabase(user: User): Completable {
        return Completable.complete()
    }

    override fun createUser(email: String, password: String): Completable {
        return Completable.complete()
    }

    override fun sendConfirmationEmail(): Completable {
        return Completable.complete()
    }

    override fun getUser(): Single<User> {
        return Single.never()
    }

}