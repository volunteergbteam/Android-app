package ru.nightgoat.volunteer.data

import android.location.Address
import com.google.android.gms.maps.model.LatLng
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import ru.nightgoat.volunteer.data.db.mDao
import ru.nightgoat.volunteer.data.model.Area
import ru.nightgoat.volunteer.domain.Repository
import ru.nightgoat.volunteer.data.network.API
import ru.nightgoat.volunteer.data.model.EventModel
import ru.nightgoat.volunteer.data.model.User
import ru.nightgoat.volunteer.objects.ChatMessage
import ru.nightgoat.volunteer.objects.ChatRoom

class ApiRepositoryImpl(private val mDao: mDao, private val api: API) : Repository {

    private val errorThrowable = Exception("This repository not implemented!")
    override fun getEvent(city: Int, eventId: String): Single<EventModel> {
        throw errorThrowable
    }

    override fun getEvents(locationId: Int) : Flowable<List<EventModel>> {
        throw errorThrowable
    }

    override fun getMyEvents(): Flowable<EventModel> {
        throw errorThrowable
    }

    override fun addUserToDatabase(user: User): Completable {
        throw errorThrowable
    }

    override fun createUser(email: String, password: String): Completable {
        throw errorThrowable
    }

    override fun sendConfirmationEmail(): Completable {
        throw errorThrowable
    }

    override fun getUser(): Single<User> {
        throw errorThrowable
    }

    override fun addEvent(
        title: String,
        description: String,
        latLng: LatLng,
        whenEnds: Long,
        city: Int,
        status: Int,
        address: String
    ): Completable {
        throw errorThrowable
    }

    override fun getAreas(): Single<List<Area>> {
        throw errorThrowable
    }

    override fun getChatList(): Flowable<ChatRoom> {
        throw errorThrowable
    }

    override fun getChatMessages(eventId: String): Flowable<ChatMessage> {
        throw errorThrowable
    }

    override fun addChatMessage(eventId: String, message: ChatMessage): Completable {
        throw errorThrowable
    }

}